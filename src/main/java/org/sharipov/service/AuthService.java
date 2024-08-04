package org.sharipov.service;



import org.sharipov.container.ComponentContainer;
import org.sharipov.controller.AdminController;
import org.sharipov.controller.StaffController;
import org.sharipov.controller.StudentController;
import org.sharipov.dto.Profile;
import org.sharipov.enums.ProfileRole;
import org.sharipov.enums.ProfileStatus;
import org.sharipov.repository.ProfileRepository;
import org.sharipov.util.MD5Util;
import org.sharipov.util.ProfileValidationUtil;

import java.time.LocalDateTime;

public class AuthService {

    private ProfileRepository profileRepository;
    private StudentController studentController;
    private AdminController adminController;
    private StaffController staffController;
    public static Profile currentProfile;

    public void login(String login, String password) {
        Profile profile = profileRepository.getByLogin(login);
        if (profile == null) {
            System.out.println("Login or Password wrong.");
            return;
        }
        String md5Hash = MD5Util.encode(password);
        if (!md5Hash.equals(profile.getPassword())) {
            System.out.println("Login or Password wrong.");
            return;
        }
        if (!profile.getStatus().equals(ProfileStatus.ACTIVE)) {
            System.out.println("Wrong status mazgi.");
            return;
        }
        System.out.println("** Welcome to library project **");
        // redirect
        currentProfile = profile;
        if (profile.getRole().equals(ProfileRole.STUDENT)) {
            studentController.start();
        } else if (profile.getRole().equals(ProfileRole.ADMIN)) {
            adminController.start();
        } else if (profile.getRole().equals(ProfileRole.STAFF)) {
            staffController.start();
        }
    }

    public void registration(Profile profile) {
        // check
        if (!ProfileValidationUtil.isValid(profile)) {
            return;
        }
        // check login
        Profile existProfile = profileRepository.getByLogin(profile.getLogin());
        if (existProfile != null) {
            System.out.println("Login exists. Please choose other login. Mazgi");
            return;
        }
        // save
        profile.setCreatedDate(LocalDateTime.now());
        profile.setRole(ProfileRole.STUDENT);
        profile.setStatus(ProfileStatus.ACTIVE);
        profile.setPassword(MD5Util.encode(profile.getPassword()));
        int effectedRow = profileRepository.create(profile);
        if (effectedRow == 1) {
            System.out.println("Registration completed.");
        }
    }

    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void setStudentController(StudentController studentController) {
        this.studentController = studentController;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setStaffController(StaffController staffController) {
        this.staffController = staffController;
    }
}

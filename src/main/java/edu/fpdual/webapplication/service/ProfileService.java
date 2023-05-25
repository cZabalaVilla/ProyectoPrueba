package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.Profile;
import edu.fpdual.webapplication.dto.User;

import java.util.List;

public class ProfileService {
    private final ProfileClient profileClient;

    public ProfileService(ProfileClient profileClient) {
        this.profileClient = profileClient;
    }

    public String ping() {
        return profileClient.ping();
    }

    public List<Profile> getAllProfiles() {
        return profileClient.get();
    }

    public Profile getProfile(String userId) {
        return profileClient.get(userId);
    }

    public boolean updateProfile(Profile profile) {
        return profileClient.put(profile);
    }

    public boolean createProfile(Profile profile) {
        return profileClient.post(profile);
    }

    public boolean deleteProfile(Profile profile) {
        return profileClient.delete(profile);
    }
}

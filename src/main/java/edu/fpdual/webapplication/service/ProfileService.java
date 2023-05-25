package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.dto.Profile;

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

    public Profile getProfile(int userId) {
        return profileClient.get(userId);
    }

    public Profile getProfile(String email) {
        return profileClient.get(email);
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

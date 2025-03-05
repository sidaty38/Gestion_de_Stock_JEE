package GestionStock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordRequest {
    @JsonProperty
    private String newPassword;

    public PasswordRequest() {}

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
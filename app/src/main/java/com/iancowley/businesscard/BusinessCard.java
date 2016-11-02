package com.iancowley.businesscard;

/**
 * Created by iancowley on 10/19/16.
 */

public class BusinessCard {

    public final String firstName;
    public final String lastName;
    public final String mobilePhone;
    public final String workPhone;
    public final String personalEmail;
    public final String workEmail;
    public final String title;
    public final String qrCodeInfo;

    private BusinessCard(BusinessCard.Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mobilePhone = builder.mobilePhone;
        this.workPhone = builder.workPhone;
        this.personalEmail = builder.personalEmail;
        this.workEmail = builder.workEmail;
        this.title = builder.title;
        this.qrCodeInfo = builder.qrCodeInfo;
    }

    public static class Builder {
        private String firstName = "";
        private String lastName = "";
        private String mobilePhone;
        private String workPhone;
        private String personalEmail;
        private String workEmail;
        private String title;
        private String qrCodeInfo;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mobilePhone(String phone) {
            this.mobilePhone = phone;
            return this;
        }

        public Builder workPhone(String phone) {
            this.workPhone = phone;
            return this;
        }

        public Builder personalEmail(String email) {
            this.personalEmail = email;
            return this;
        }

        public Builder workEmail(String email) {
            this.workEmail = email;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder qrCodeInfo(String info) {
            this.qrCodeInfo = info;
            return this;
        }

        public BusinessCard build() {
            return new BusinessCard(this);
        }

    }

}

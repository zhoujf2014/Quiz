package com.gtafe.quiz;

/**
 * Created by ZhouJF on 2018/1/11.
 */

public class LoginBean {

    /**
     * errcode : 0
     * user_info : {"createdTime":1460449350000,"creator":"","delFlag":0,"editedTime":1495767198000,"editor":"3ce2b9ae9c0a4ff0b7d1be69bbcec93d","endTime":4423626716000,"isForever":0,"startTime":1457341911000,"state":0,"userCName":"超级管理员","userCode":"admin","userDesc":"","userEmail":"","userGender":1,"userId":"3ce2b9ae9c0a4ff0b7d1be69bbcec93d","userName":"admin","userPhoto":"","userPwd":"d1d208e31e0bddb14d1a30b222893b8f","userType":1}
     * errmsg : success
     */

    private int errcode;
    private UserInfoBean user_info;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static class UserInfoBean {
        /**
         * createdTime : 1460449350000
         * creator :
         * delFlag : 0
         * editedTime : 1495767198000
         * editor : 3ce2b9ae9c0a4ff0b7d1be69bbcec93d
         * endTime : 4423626716000
         * isForever : 0
         * startTime : 1457341911000
         * state : 0
         * userCName : 超级管理员
         * userCode : admin
         * userDesc :
         * userEmail :
         * userGender : 1
         * userId : 3ce2b9ae9c0a4ff0b7d1be69bbcec93d
         * userName : admin
         * userPhoto :
         * userPwd : d1d208e31e0bddb14d1a30b222893b8f
         * userType : 1
         */

        private long createdTime;
        private String creator;
        private int delFlag;
        private long editedTime;
        private String editor;
        private long endTime;
        private int isForever;
        private long startTime;
        private int state;
        private String userCName;
        private String userCode;
        private String userDesc;
        private String userEmail;
        private int userGender;
        private String userId;
        private String userName;
        private String userPhoto;
        private String userPwd;
        private int userType;

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public long getEditedTime() {
            return editedTime;
        }

        public void setEditedTime(long editedTime) {
            this.editedTime = editedTime;
        }

        public String getEditor() {
            return editor;
        }

        public void setEditor(String editor) {
            this.editor = editor;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getIsForever() {
            return isForever;
        }

        public void setIsForever(int isForever) {
            this.isForever = isForever;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getUserCName() {
            return userCName;
        }

        public void setUserCName(String userCName) {
            this.userCName = userCName;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserDesc() {
            return userDesc;
        }

        public void setUserDesc(String userDesc) {
            this.userDesc = userDesc;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public int getUserGender() {
            return userGender;
        }

        public void setUserGender(int userGender) {
            this.userGender = userGender;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPhoto() {
            return userPhoto;
        }

        public void setUserPhoto(String userPhoto) {
            this.userPhoto = userPhoto;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }
    }
}

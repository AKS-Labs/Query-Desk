package com.qlearn.query_desk.Model;

public class Follow {
    private static String followedBy;
//    private String followedBy;
    private long followedAt;

    public Follow() {
    }

    public static String getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(String followedBy) {
        this.followedBy = followedBy;
    }

    public long getFollowedAt() {
        return followedAt;
    }

    public void setFollowedAt(long followedAt) {
        this.followedAt = followedAt;
    }
}

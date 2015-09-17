package com.jal.stela.common.bean;

/**
 * Created by K.Kangai on 2015/07/31.
 */
public class SshInfo {

    private String url;

    private int port;

    private String user;

    private String pass;

    private SshKey key;

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public SshKey getKey() {
        return key;
    }

    public SshInfo(String url, int port, String user, String pass) {
        this.url = url;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public SshInfo(String url, int port, String user, SshKey key) {
        this.url = url;
        this.port = port;
        this.user = user;
        this.key = key;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SshInfo{");
        sb.append("url='").append(url).append('\'');
        sb.append(", port=").append(port);
        sb.append(", user='").append(user).append('\'');
        sb.append(", pass='").append(pass).append('\'');
        sb.append(", key=").append(key);
        sb.append('}');
        return sb.toString();
    }
}

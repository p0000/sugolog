package com.jal.stela.common.handler.impl;

import com.jal.stela.common.bean.SshInfo;
import com.jal.stela.common.bean.SshResultInfo;
import com.jal.stela.common.handler.SshHandler;
import org.springframework.stereotype.Component;
import com.jcabi.ssh.SSHByPassword;
import com.jcabi.ssh.Shell;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by K.Kangai on 2015/07/31.
 */
@Component
public class SshHandlerImpl implements SshHandler{

    @Override
    public SshResultInfo execute(SshInfo info, String command) {
        SshResultInfo result;
        Shell shell;
        try {
            shell = this.connect(info);
        } catch (UnknownHostException e)  {
            e.printStackTrace();
            return new SshResultInfo("Cannot connect ssh server:" + info.toString(), -1);
        }

        try {
            String stdout = new Shell.Plain(shell).exec(command);
            result = new SshResultInfo(stdout,0);

        } catch (IOException e) {
            e.printStackTrace();
            return new SshResultInfo("Fail to execute command:" + info.toString(), -1);
        }

        return result;
    }

    private Shell connect(SshInfo info) throws UnknownHostException {
        Shell shell = new SSHByPassword(
                    info.getUrl(), info.getPort(), info.getUser(), info.getPass());
        return shell;
    }
}

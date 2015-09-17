package com.jal.stela.common.handler;

import com.jal.stela.common.bean.SshInfo;
import com.jal.stela.common.bean.SshResultInfo;

/**
 * Created by K.Kangai on 2015/07/31.
 */
public interface SshHandler {

    SshResultInfo execute(SshInfo info, String command);

}

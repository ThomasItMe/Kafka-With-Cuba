package com.company.kafkawithcuba.web.sernder;

import com.company.kafkawithcuba.service.SerderMessageService;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("kafkawithcuba_Messagesender")
@UiDescriptor("MessageSender.xml")
public class Messagesender extends Screen {
    @Inject
    private TextArea<String> messageText;

    @Inject
    private SerderMessageService serderMessageService;

    @Subscribe("sendMsg")
    public void onSendMsg(Action.ActionPerformedEvent event) {
        serderMessageService.sendMessage(messageText.getRawValue());
        messageText.setValue("");
        closeWithDefaultAction();
    }


}
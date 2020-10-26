package com.company.kafkawithcuba.web.screens.messagekafka;

import com.haulmont.cuba.gui.screen.*;
import com.company.kafkawithcuba.entity.MessageKafka;

@UiController("kafkawithcuba_MessageKafka.browse")
@UiDescriptor("message-kafka-browse.xml")
@LookupComponent("messageKafkasTable")
@LoadDataBeforeShow
public class MessageKafkaBrowse extends StandardLookup<MessageKafka> {
}
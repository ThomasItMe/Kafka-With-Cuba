package com.company.kafkawithcuba.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "KAFKAWITHCUBA_MESSAGE_KAFKA")
@Entity(name = "kafkawithcuba_MessageKafka")
public class MessageKafka extends StandardEntity {
    private static final long serialVersionUID = 6385678116230251474L;

    @Column(name = "STT")
    private Integer stt;

    @Column(name = "COMMENT_")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }
}
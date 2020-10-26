-- begin KAFKAWITHCUBA_MESSAGE_KAFKA
create table KAFKAWITHCUBA_MESSAGE_KAFKA (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    STT integer,
    COMMENT_ varchar(255),
    --
    primary key (ID)
)^
-- end KAFKAWITHCUBA_MESSAGE_KAFKA

CREATE DATABASE mall character SET utf8;

USE mall;

CREATE TABLE t_user
(
    uid           INT AUTO_INCREMENT COMMENT '用户id',
    username      VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    type          VARCHAR(20) NOT NULL COMMENT '注册类型',
    password      CHAR(32)    NOT NULL COMMENT '密码',
    salt          CHAR(36) COMMENT '盐值',
    phone         VARCHAR(20) COMMENT '电话号码',
    email         VARCHAR(30) COMMENT '电子邮箱',
    gender        INT COMMENT '性别:0-女，1-男',
    avatar        VARCHAR(50) COMMENT '头像',
    is_delete     INT COMMENT '是否删除：0-未删除，1-已删除',
    created_user  VARCHAR(20) COMMENT '日志-创建人',
    created_time  DATETIME COMMENT '日志-创建时间',
    modified_user VARCHAR(20) COMMENT '日志-最后修改执行人',
    modified_time DATETIME COMMENT '日志-最后修改时间',
    PRIMARY KEY (uid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_shop
(
    sid              INT AUTO_INCREMENT COMMENT '商店id',
    username         VARCHAR(20) NOT NULL UNIQUE COMMENT '商户用户名',
    password         CHAR(32)    NOT NULL COMMENT '商户的密码',
    salt             CHAR(36) COMMENT '商户的盐值',
    shopname         VARCHAR(20) NOT NULL COMMENT '商店名',
    fans_number      INT(20) DEFAULT '0' COMMENT '商店粉丝数量',
    phone            VARCHAR(20) COMMENT '电话号码',
    email            VARCHAR(30) COMMENT '电子邮箱',
    address          VARCHAR(50) COMMENT '商店地址',
    is_authenticated INT COMMENT '是否认证：0-未认证，1-已认证',
    created_user     VARCHAR(20) COMMENT '日志-创建人',
    created_time     DATETIME COMMENT '日志-创建时间',
    modified_user    VARCHAR(20) COMMENT '日志-最后修改执行人',
    modified_time    DATETIME COMMENT '日志-最后修改时间',
    PRIMARY KEY (sid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE t_address
(
    aid           INT AUTO_INCREMENT COMMENT '收货地址id',
    uid           INT COMMENT '归属的用户id',
    name          VARCHAR(20) COMMENT '收货人姓名',
    area_name     VARCHAR(15) COMMENT '校区-名称',
    address       VARCHAR(50) COMMENT '详细地址',
    phone         VARCHAR(20) COMMENT '手机',
    is_default    INT COMMENT '是否默认：0-不默认，1-默认',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (aid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_product
(
    pid           INT(20) AUTO_INCREMENT COMMENT '商品id',
    sid           INT           NOT NULL COMMENT '所属商店id',
    product_name  VARCHAR(50)   NOT NULL COMMENT '商品名称',
    price         DOUBLE       DEFAULT NULL COMMENT '商品单价',
    details       VARCHAR(1000) NOT NULL COMMENT '商品描述',
    storage       INT(10)      DEFAULT NULL COMMENT '库存数量',
    image         VARCHAR(500) DEFAULT NULL COMMENT '图片路径',
    status        INT(1)       DEFAULT '1' COMMENT '商品状态  1：上架   2：下架   3：删除',
    priority      INT(10)      DEFAULT NULL COMMENT '显示优先级',
    created_time  DATETIME     DEFAULT NULL COMMENT '创建时间',
    modified_time DATETIME     DEFAULT NULL COMMENT '最后修改时间',
    created_user  VARCHAR(50)  DEFAULT NULL COMMENT '创建人',
    modified_user VARCHAR(50)  DEFAULT NULL COMMENT '最后修改人',
    PRIMARY KEY (pid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_version
(
    vid     INT(20) AUTO_INCREMENT COMMENT '版本条目id',
    version VARCHAR(50) NOT NULL COMMENT '版本名称',
    pid     INT(20)     NOT NULL COMMENT '对应商品id',
    PRIMARY KEY (vid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_comment
(
    cid     INT AUTO_INCREMENT COMMENT '评价id',
    uid     INT    NOT NULL COMMENT '评价用户id',
    pid     INT    NOT NULL COMMENT '被评价商品id',
    rate    DOUBLE NOT NULL COMMENT '评分',
    content VARCHAR(1000) DEFAULT NULL COMMENT '评价内容',
    PRIMARY KEY (cid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_cart
(
    cid           INT AUTO_INCREMENT COMMENT '购物车数据id',
    uid           INT NOT NULL COMMENT '用户id',
    pid           INT NOT NULL COMMENT '商品id',
    num           INT COMMENT '商品数量',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (cid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_order
(
    oid           INT AUTO_INCREMENT COMMENT '订单id',
    uid           INT NOT NULL COMMENT '用户id',
    aid           INT NOT NULL COMMENT '对应收获地址id',
    total_price   BIGINT COMMENT '总价',
    status        INT COMMENT '状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成',
    order_time    DATETIME COMMENT '下单时间',
    pay_time      DATETIME COMMENT '支付时间',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (oid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_order_item
(
    oiid          INT AUTO_INCREMENT COMMENT '订单条目id',
    oid           INT NOT NULL COMMENT '所属订单id',
    pid           INT NOT NULL COMMENT '订单条目包含的商品id',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (oiid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_favorite_product
(
    fpid          INT AUTO_INCREMENT COMMENT '收藏商品数据id',
    uid           INT NOT NULL COMMENT '用户id',
    pid           INT NOT NULL COMMENT '商品id',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (fpid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_favorite_shop
(
    fsid          INT AUTO_INCREMENT COMMENT '收藏店铺数据id',
    uid           INT NOT NULL COMMENT '用户id',
    pid           INT NOT NULL COMMENT '商品id',
    created_user  VARCHAR(20) COMMENT '创建人',
    created_time  DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '修改人',
    modified_time DATETIME COMMENT '修改时间',
    PRIMARY KEY (fsid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE t_image
(
    iid       INT AUTO_INCREMENT COMMENT '图片id',
    pid       INT           NOT NULL COMMENT '对应商品id',
    image_src VARCHAR(1000) NOT NULL COMMENT '图片内容',
    PRIMARY KEY (iid)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


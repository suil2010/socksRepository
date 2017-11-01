drop table member

CREATE TABLE member (
   member_ID  VARCHAR2(30) primary key, -- 회원_ID
   NAME     VARCHAR2(30) NOT NULL, -- 이름
   PASSWORD VARCHAR2(30) NOT NULL, -- 비밀번
   ADDRESS  VARCHAR2(60) NOT NULL, -- 주소
   EMAIL    VARCHAR2(30) NOT NULL, -- 이메
   POINT    NUMBER(5)    NULL      -- 포인
);

drop table item cascade constraint

CREATE TABLE ITEM (
   ITEM_ID       VARCHAR2(30) primary key, -- 상품번호
   ITEM_PRICE    NUMBER(10)   NOT NULL, -- 제품단
   ITEM_QUANTITY NUMBER(10)   NOT NULL, -- 전체제품수
   ITEM_NAME     VARCHAR2(30) NOT NULL, -- 상품이름
   MAIN_CUT      VARCHAR2(50) NOT NULL, -- 메인사진주소
   DETAIL_CUT    VARCHAR2(50) NOT NULL  -- 상세사진주소
);

drop table order_list

CREATE TABLE order_list(
   order_id VARCHAR2(30) primary key, -- 주문상품
   ORDER_QUANTITY NUMBER(3) not NULL, -- 주문수
   order_date date not null,
   member_id VARCHAR2(10) constraint fk_order_user_id references member,
   item_id  VARCHAR2(30) constraint fk_item_user_id references item
);

select * from item

insert into member values('userId-1','김창수','2444','경기도 파주','s@s.com',500);
insert into member values('userId-2','장발장','2345','경기도 하남','a@s.com',500);
insert into member values('userId-3','강감찬','5676','경기도 용인','b@s.com',500);

--파열경로 ex) C:\java\apache-tomcat-8.0.47\webapps\FileuploadExam_image\upImage\fileName
insert into item values('itemId-1',12000,1000,'긴 양말','C:\','D:\');
insert into item values('itemId-2',13000,100,'발목 양말','C:\','D:\');
insert into item values('itemId-3',14000,200,'겨울 양말','C:\','D:\');
insert into item values('itemId-7',1400,1200,'양말',
'main.jpg',
'detail.jpg');

-- 만약에 주문을 구현하면 전체제품수에서 주문개수를 뺀다.
insert into order_list values('orderId-1',12,'2017-10-30','userId-1','itemId-1');
insert into order_list values('orderId-2',1,'2017-10-30','userId-1','itemId-2');
insert into order_list values('orderId-3',2,'2017-10-30','userId-1','itemId-3');

select * from item where item_id = 'itemId-7';

insert into order_list values('orderId-4',4,'2017-10-30','userId-2','itemId-1');
insert into order_list values('orderId-5',5,'2017-10-30','userId-2','itemId-2');
insert into order_list values('orderId-6',6,'2017-10-30','userId-2','itemId-3');

insert into order_list values('orderId-7',7,'2017-10-30','userId-3','itemId-1');
insert into order_list values('orderId-8',8,'2017-10-30','userId-3','itemId-2');
insert into order_list values('orderId-9',9,'2017-10-30','userId-3','itemId-3');

select * from member
select * from item
select * from order_list

        SELECT m.member_id ,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            i.item_id,
            i.item_price,
            i.item_quantity,
            i.item_name,
            i.MAIN_CUT,
            i.DETAIL_CUT,
            o.order_id,
            o.ORDER_QUANTITY
      FROM   member m , order_list o,item i
      WHERE  m.member_id = o.member_id(+)
      and    i.item_id = o.item_id
      
      --member를 기준으로 조회
      SELECT m.member_id ,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            o.order_id,
            o.ORDER_QUANTITY,
            i.item_price,
            i.item_quantity,
            i.item_name
      FROM   member m ,order_list o,item i
      WHERE  m.member_id = o.member_id
      and    i.item_id = o.item_id
      
      --item으로 조회
      SELECT 
            i.item_id,
            i.item_price,
            i.item_quantity,
            i.item_name,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            o.order_id,
            o.ORDER_QUANTITY
      FROM   member m , order_list o,item i
      WHERE  i.item_id = o.item_id
      AND    m.member_id = o.member_id
      
      -- 이름으로 조회
      SELECT m.member_id ,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            o.order_id,
            o.ORDER_QUANTITY,
            o.order_date,
            i.item_price,
            i.item_quantity,
            i.item_name
      FROM   member m , order_list o,item i
      WHERE  m.member_id = o.member_id
      and    i.item_id = o.item_id
      and    m.name = '김창수'
      
      -- #############################
      SELECT m.member_id ,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            o.order_id,
            o.ORDER_QUANTITY,
            i.item_price,
            i.item_quantity,
            i.item_name
      FROM   member m , shoppingBask o,item i
      WHERE  m.member_id = o.member_id
      and    i.item_id = o.item_id
      and    m.member_id = 'userId-2'
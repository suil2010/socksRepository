drop table member cascade constraint

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
   member_id VARCHAR2(10) constraint fk_order_user_id references member on delete cascade,
   item_id  VARCHAR2(30) constraint fk_item_item_id references item on delete cascade,
   order_date date not null
);

drop table order_member cascade constraint

create table order_member(
	order_num varchar2(30) primary key,
	member_id VARCHAR2(10) constraint fk_order_member_user_id references member on delete cascade,
	order_date date not null
)

drop table order_detail cascade constraint

create table order_detail(
	order_detail_id varchar2(30) primary key,
	order_num varchar2(30) constraint fk_order_detail_member_id references order_member on delete cascade,
	ITEM_ID         VARCHAR2(30) not null,
	ORDER_QUANTITY  NUMBER(3) not NULL, -- 주문수
	ITEM_PRICE      NUMBER(10)   NOT NULL,
	ITEM_NAME       VARCHAR2(30) NOT NULL,
	MAIN_CUT        VARCHAR2(50) NOT NULL
)




insert into order_member values('orderNum-1','userId-1','2017-07-01');
insert into order_member values('orderNum-2','userId-1','2017-07-01');
insert into order_member values('orderNum-3','userId-1','2017-07-01');
insert into order_member values('orderNum-4','userId-2','2017-07-01');
insert into order_member values('orderNum-5','userId-2','2017-07-01');
insert into order_member values('orderNum-6','userId-3','2017-07-01');
insert into order_member values('orderNum-7','userId-3','2017-07-01');

insert into order_detail values('orderDetailId-1','orderNum-1','itemId-1',1,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-2','orderNum-1','itemId-2',2,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-3','orderNum-1','itemId-3',3,12000,'기타리스트 루스터', '1052.jpg');

insert into order_detail values('orderDetailId-4','orderNum-2','itemId-1',3,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-5','orderNum-2','itemId-1',2,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-6','orderNum-2','itemId-2',1,12000,'기타리스트 루스터', '1052.jpg');

insert into order_detail values('orderDetailId-7','orderNum-4','itemId-2',1,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-8','orderNum-6','itemId-2',1,12000,'기타리스트 루스터', '1052.jpg');
insert into order_detail values('orderDetailId-9','orderNum-7','itemId-2',1,12000,'기타리스트 루스터', '1052.jpg');

select * from ORDER_MEMBER

select * from ORDER_DETAIL

select * from item

insert into member values('userId-1','김창수','2444','경기도 파주','s@s.com',500);
insert into member values('userId-2','장발장','2345','경기도 하남','a@s.com',500);
insert into member values('userId-3','강감찬','5676','경기도 용인','b@s.com',500);

--파열경로 ex) C:\java\apache-tomcat-8.0.47\webapps\FileuploadExam_image\upImage\fileName

delete from MEMBER where member_id = '222' cascade 
delete from item where item_id = 'itemId-13'
delete from item where item_id = 'itemId-7'
delete from ORDER_LISt
select * from order_list

insert into item values('itemId-1',12000,1000,'기타리스트 루스터', '1052.jpg', '1052d.jpg');
insert into item values('itemId-2',12000,1000,'드러머 동키', '1049.jpg', '1049d.jpg');
insert into item values('itemId-3',12000,1000,'트럼펫 도그', '1050.jpg', '1050d.jpg');
insert into item values('itemId-4',20000,1000,'쥬얼 리미티드 베이지', '1083.jpg', '1083d.jpg');
insert into item values('itemId-5',12000,1000,'쥬얼 베이지', '1082.jpg', '1082d.jpg');
insert into item values('itemId-6',12000,1000,'쥬얼 블랙', '1081.jpg', '1081d.jpg');
insert into item values('itemId-7',24000,1000,'슬릭타이 카키브라운', '1069.jpg', '1069d.jpg');
insert into item values('itemId-8',12000,1000,'슬릭 삭스 라벤더', '1068.jpg', '1068d.jpg');
insert into item values('itemId-9',12000,1000,'슬릭 삭스 레드', '1067.jpg', '1067d.jpg');
insert into item values('itemId-10',12000,1000,'슬릭 삭스 스모키블루', '1066.jpg', '1066d.jpg');
insert into item values('itemId-11',12000,1000,'슬릭 삭스 카키브라운', '1065.jpg', '1065d.jpg');
insert into item values('itemId-12',12000,1000,'라임삭스 멜고라운드', '1062.jpg', '1062d.jpg');
insert into item values('itemId-13',12000,1000,'라임삭스 범퍼카', '1061.jpg', '1061d.jpg');
insert into item values('itemId-14',12000,1000,'라임삭스 페리스휠', '1060.jpg', '1060d.jpg');
insert into item values('itemId-15',12000,1000,'라임삭스 롤러코스터', '1059.jpg', '1059d.jpg');
insert into item values('itemId-16',12000,1000,'아이스 크림', '1058.jpg', '1058d.jpg');
insert into item values('itemId-17',12000,1000,'팝콘', '1057.jpg', '1057d.jpg');
insert into item values('itemId-18',12000,1000,'초코 도넛', '1056.jpg', '1056d.jpg');
insert into item values('itemId-19',12000,1000,'핑크 도넛', '1055.jpg', '1055d.jpg');
insert into item values('itemId-20',12000,1000,'프렌치 불독', '1054.jpg', '1054d.jpg');
insert into item values('itemId-21',12000,1000,'코기', '1053.jpg', '1053d.jpg');
insert into item values('itemId-22',12000,1000,'바이올리니스트 캣', '1051.jpg', '1051d.jpg');
insert into item values('itemId-23',7000,1000,'커버 삭스 시하우스', '1040.jpg', '1040d.jpg');
insert into item values('itemId-24',7000,1000,'커버 삭스 시굴', '1039.jpg', '1039d.jpg');
insert into item values('itemId-25',7000,1000,'커버 삭스 웨일', '1038.jpg', '1038d.jpg');

-- 만약에 주문을 구현하면 전체제품수에서 주문개수를 뺀다.
insert into order_list values('orderId-1',12,'userId-1','itemId-1','2017-10-30');
insert into order_list values('orderId-2',12,'userId-2','itemId-1','2017-10-30');
insert into order_list values('orderId-3',12,'userId-3','itemId-1','2017-10-30');
insert into order_list values('orderId-4',12,'userId-1','itemId-3','2017-10-30');
insert into order_list values('orderId-5',12,'userId-1','itemId-2','2017-10-30');
insert into order_list values('orderId-6',12,'userId-1','itemId-3','2017-10-30');

----------------
insert into memberorder values('userId-1','orderId-1');

select * from item where item_id = 'itemId-7';

select * from member
select * from item
select * from order_list
		
		--회원아이디로 주문조히
		select 	m.member_id ,
            m.name,
            m.password,
            m.address,
            m.email,
            m.point,
            o.order_num,
            o.order_date,
            d.order_detail_id,
            d.ITEM_ID,
            d.ORDER_QUANTITY,
            d.ITEM_PRICE,
            d.ITEM_NAME,
            d.MAIN_CUT
		from 	member m, ORDER_MEMBER o, ORDER_DETAIL d
		where 	m.member_id = o.member_id
		and 	o.order_num = d.order_num
		and 	m.member_id = 'aa'

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
            o.order_date,
            i.item_price,
            i.item_quantity,
            i.item_name
      FROM   member m , order_list o,item i
      WHERE  m.member_id = o.member_id
      and    i.item_id = o.item_id
      and    m.member_id = 'userId-1'

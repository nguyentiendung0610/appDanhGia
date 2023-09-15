--
-- PostgreSQL database cluster dump
--

-- Started on 2023-09-15 18:44:26

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4
-- Dumped by pg_dump version 15.4

-- Started on 2023-09-15 18:44:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2023-09-15 18:44:27

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4
-- Dumped by pg_dump version 15.4

-- Started on 2023-09-15 18:44:27

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16399)
-- Name: danh_gia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.danh_gia (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    deleted boolean,
    updated_date timestamp without time zone,
    diem1 integer,
    diem2 integer,
    diem3 integer,
    diem4 integer,
    diem5 integer,
    id_sv bigint,
    status smallint,
    tong integer,
    xep_loai character varying(255)
);


ALTER TABLE public.danh_gia OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16398)
-- Name: danh_gia_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.danh_gia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.danh_gia_id_seq OWNER TO postgres;

--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 215
-- Name: danh_gia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.danh_gia_id_seq OWNED BY public.danh_gia.id;


--
-- TOC entry 218 (class 1259 OID 16406)
-- Name: hethong_nguoidung_token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hethong_nguoidung_token (
    id bigint NOT NULL,
    created_user bigint,
    token character varying(255),
    tokenexpdate timestamp without time zone
);


ALTER TABLE public.hethong_nguoidung_token OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16405)
-- Name: hethong_nguoidung_token_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hethong_nguoidung_token_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hethong_nguoidung_token_id_seq OWNER TO postgres;

--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 217
-- Name: hethong_nguoidung_token_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hethong_nguoidung_token_id_seq OWNED BY public.hethong_nguoidung_token.id;


--
-- TOC entry 224 (class 1259 OID 16435)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16413)
-- Name: lua_chon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lua_chon (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    deleted boolean,
    updated_date timestamp without time zone,
    content character varying(255),
    point integer,
    type integer
);


ALTER TABLE public.lua_chon OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16412)
-- Name: lua_chon_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lua_chon_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lua_chon_id_seq OWNER TO postgres;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 219
-- Name: lua_chon_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lua_chon_id_seq OWNED BY public.lua_chon.id;


--
-- TOC entry 222 (class 1259 OID 16420)
-- Name: nguoi_dung; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nguoi_dung (
    id bigint NOT NULL,
    created_date timestamp without time zone,
    deleted boolean,
    updated_date timestamp without time zone,
    address character varying(255),
    avatar character varying(255),
    email character varying(255),
    full_name character varying(255),
    gioi_tinh boolean,
    ngay_sinh timestamp without time zone,
    password character varying(255),
    role smallint,
    sdt character varying(255),
    status smallint,
    user_name character varying(255)
);


ALTER TABLE public.nguoi_dung OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16419)
-- Name: nguoi_dung_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nguoi_dung_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nguoi_dung_id_seq OWNER TO postgres;

--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 221
-- Name: nguoi_dung_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nguoi_dung_id_seq OWNED BY public.nguoi_dung.id;


--
-- TOC entry 223 (class 1259 OID 16428)
-- Name: one_signal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.one_signal (
    id bigint NOT NULL,
    id_one_signal character varying(255),
    user_name character varying(255)
);


ALTER TABLE public.one_signal OWNER TO postgres;

--
-- TOC entry 3194 (class 2604 OID 16402)
-- Name: danh_gia id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.danh_gia ALTER COLUMN id SET DEFAULT nextval('public.danh_gia_id_seq'::regclass);


--
-- TOC entry 3195 (class 2604 OID 16409)
-- Name: hethong_nguoidung_token id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hethong_nguoidung_token ALTER COLUMN id SET DEFAULT nextval('public.hethong_nguoidung_token_id_seq'::regclass);


--
-- TOC entry 3196 (class 2604 OID 16416)
-- Name: lua_chon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lua_chon ALTER COLUMN id SET DEFAULT nextval('public.lua_chon_id_seq'::regclass);


--
-- TOC entry 3197 (class 2604 OID 16423)
-- Name: nguoi_dung id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nguoi_dung ALTER COLUMN id SET DEFAULT nextval('public.nguoi_dung_id_seq'::regclass);


--
-- TOC entry 3352 (class 0 OID 16399)
-- Dependencies: 216
-- Data for Name: danh_gia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.danh_gia (id, created_date, deleted, updated_date, diem1, diem2, diem3, diem4, diem5, id_sv, status, tong, xep_loai) FROM stdin;
\.


--
-- TOC entry 3354 (class 0 OID 16406)
-- Dependencies: 218
-- Data for Name: hethong_nguoidung_token; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hethong_nguoidung_token (id, created_user, token, tokenexpdate) FROM stdin;
\.


--
-- TOC entry 3356 (class 0 OID 16413)
-- Dependencies: 220
-- Data for Name: lua_chon; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lua_chon (id, created_date, deleted, updated_date, content, point, type) FROM stdin;
1	2023-09-15 17:27:12.245	f	2023-09-15 17:27:12.245	Học lực yếu	-3	1
2	2023-09-15 17:27:33.238	f	2023-09-15 17:27:33.238	Bị cảnh báo học vụ	-5	1
3	2023-09-15 17:28:01.351	f	2023-09-15 17:28:01.351	Đăng ký không đủ tín chỉ theo Quy định	-5	1
4	2023-09-15 17:28:49.49	f	2023-09-15 17:28:49.49	Không tham gia NCKH the Quy định (đối với sinh viên NVCL): -5đ/lần	-5	1
5	2023-09-15 17:32:07.359	f	2023-09-15 17:32:07.359	Nộp hoặc nhận không đúng một khoản kinh phí: -5đ/lần	-5	2
6	2023-09-15 17:32:40.418	f	2023-09-15 17:32:40.418	Đăng ký học quá hạn (nếu được chấp nhận)	-2	2
7	2023-09-15 17:32:55.466	f	2023-09-15 17:32:55.466	Không thực hiện theo Giấy triệu tập/Yêu cầu của Nhà trường: -5đ/lần	-5	2
8	2023-09-15 17:33:13.08	f	2023-09-15 17:33:13.08	Trả quá hạn giấy tờ/hồ sơ đã được phép mượn: -5đ/lần	-5	2
9	2023-09-15 17:33:22.065	f	2023-09-15 17:33:22.065	Không tham gia Bảo hiểm Y tế: -5đ	-5	2
10	2023-09-15 17:33:37.545	f	2023-09-15 17:33:37.545	Vi phạm quy định nơi cư trú: -10đ/lần	-10	2
11	2023-09-15 17:33:57.034	f	2023-09-15 17:33:57.034	Tham gia đầy đủ các hoạt động của chi đoàn và tham gia đầy đủ các buổi sinh hoạt chính trị theo triệu tập (nếu có) của Nhà trường: +10đ	10	3
12	2023-09-15 17:34:36.038	f	2023-09-15 17:34:36.038	Tham gia (có giấy xác nhận) các hoạt động văn nghệ, thể thao, câu lạc bộ, hoạt động tình nguyện...: +2đ/lần	2	3
13	2023-09-15 17:34:49.69	f	2023-09-15 17:34:49.69	Không tham gia Sinh hoạt chính trị theo Quy định: -2đ/lần	-2	3
14	2023-09-15 17:37:10.132	f	2023-09-15 17:37:10.132	Có thông báo bằng văn bản về việc không chấp hành các chủ trương của Đảng, chính sách pháp luật của Nhà nước, vi phạm an ninh chính trị, trật tự an toàn xã hội, an toàn giao thông,...: -5đ/lần	-5	4
15	2023-09-15 17:37:25.627	f	2023-09-15 17:37:25.627	Không có tinh thần giúp đỡ bạn bè, không thể hiện tinh thần đoàn kết tập thể: -5đ/lần	-5	4
16	2023-09-15 17:37:47.542	f	2023-09-15 17:37:47.542	Giữ các chức vụ trong các tổ chức chính quyền, đoàn thể và được đánh giá hoàn thành tốt nhiệm vụ: +10đ	10	5
17	2023-09-15 17:37:56.976	f	2023-09-15 17:37:56.976	Được kết nạp Đảng: +10đ	10	5
18	2023-09-15 17:38:08.7	f	2023-09-15 17:38:08.7	Học lực (Xuất sắc, Giỏi): +10đ	10	5
19	2023-09-15 17:38:17.643	f	2023-09-15 17:38:17.643	Tham gia các cuộc thi chuyên môn như Procon, Olympic,...: +5đ/lần	5	5
20	2023-09-15 17:38:28.284	f	2023-09-15 17:38:28.284	Đạt giải tại các cuộc thi chuyên môn: +5đ/lần	5	5
21	2023-09-15 17:38:34.577	f	2023-09-15 17:38:34.577	Tham gia NCKH (không phải là SV NVCL): +5đ	5	5
22	2023-09-15 17:38:46.059	f	2023-09-15 17:38:46.059	Đạt giải NCKH các cấp hoặc có báo cáo tại Hội nghị NCKH/bài báo đăng trên các tạp chí trong và ngoài nước: +5đ	5	5
\.


--
-- TOC entry 3358 (class 0 OID 16420)
-- Dependencies: 222
-- Data for Name: nguoi_dung; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nguoi_dung (id, created_date, deleted, updated_date, address, avatar, email, full_name, gioi_tinh, ngay_sinh, password, role, sdt, status, user_name) FROM stdin;
1	2023-09-14 18:56:58.753	f	2023-09-14 18:56:58.753	HN		admin@gmail.com	Admin	f	2002-08-25 22:12:27.058	$2a$10$CtmocBhEXtkyDEzltTyW2uOjs0YlFX7abVSD25fKyYg75bhcx9Qqu	1	0987654321	1	admin
2	2023-09-14 18:57:56.003	f	2023-09-14 18:57:56.003	HN		cvht@gmail.com	Cố vấn học tập	f	1970-08-25 22:12:27.058	$2a$10$h8AgAGLZ9YwWVDZbBrxFe.XQRJl/jv6L4h7dvV8bgsap9MX7X9DIm	1	0987654321	1	covanhoctap
3	2023-09-14 19:00:28.14	f	2023-09-14 19:00:28.14	HN		20020456@vnu.edu.vn	Nguyễn Đức Nguyên	f	2002-08-25 22:12:27.058	$2a$10$htzGwxPIfk1vs6YqTXwl8.Y8eBFrvNilMbRTMDoSBgusIK96fqW/W	2	0987654321	1	20020456
4	2023-09-14 19:01:05.541	f	2023-09-14 19:01:05.541	HN		20020382@vnu.edu.vn	Nguyễn Tiến Dũng	f	2002-10-06 22:12:27.058	$2a$10$Isn9B5AThcvp4qD08zkx0.3KJ6BPs10szw.3YfTFHqoIGJsu14e2m	3	0398570973	1	20020382
5	2023-09-14 19:01:42.106	f	2023-09-14 19:01:42.106	HN		20020204@vnu.edu.vn	Phạm Thị Kim Ngân	t	2002-10-06 22:12:27.058	$2a$10$wwlmOGESLh9Js83reUfCW.GrCDONZN2tKxKiBAttapEwMlqhRisbq	3	0987654321	1	20020204
\.


--
-- TOC entry 3359 (class 0 OID 16428)
-- Dependencies: 223
-- Data for Name: one_signal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.one_signal (id, id_one_signal, user_name) FROM stdin;
\.


--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 215
-- Name: danh_gia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.danh_gia_id_seq', 1, false);


--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 217
-- Name: hethong_nguoidung_token_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hethong_nguoidung_token_id_seq', 1, false);


--
-- TOC entry 3373 (class 0 OID 0)
-- Dependencies: 224
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3374 (class 0 OID 0)
-- Dependencies: 219
-- Name: lua_chon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lua_chon_id_seq', 22, true);


--
-- TOC entry 3375 (class 0 OID 0)
-- Dependencies: 221
-- Name: nguoi_dung_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nguoi_dung_id_seq', 5, true);


--
-- TOC entry 3199 (class 2606 OID 16404)
-- Name: danh_gia danh_gia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.danh_gia
    ADD CONSTRAINT danh_gia_pkey PRIMARY KEY (id);


--
-- TOC entry 3201 (class 2606 OID 16411)
-- Name: hethong_nguoidung_token hethong_nguoidung_token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hethong_nguoidung_token
    ADD CONSTRAINT hethong_nguoidung_token_pkey PRIMARY KEY (id);


--
-- TOC entry 3203 (class 2606 OID 16418)
-- Name: lua_chon lua_chon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lua_chon
    ADD CONSTRAINT lua_chon_pkey PRIMARY KEY (id);


--
-- TOC entry 3205 (class 2606 OID 16427)
-- Name: nguoi_dung nguoi_dung_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nguoi_dung
    ADD CONSTRAINT nguoi_dung_pkey PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 16434)
-- Name: one_signal one_signal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.one_signal
    ADD CONSTRAINT one_signal_pkey PRIMARY KEY (id);


--
-- TOC entry 3208 (class 2606 OID 16436)
-- Name: danh_gia fksrw6jl9lbkytyxpacgmx8rwqo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.danh_gia
    ADD CONSTRAINT fksrw6jl9lbkytyxpacgmx8rwqo FOREIGN KEY (id_sv) REFERENCES public.nguoi_dung(id);


-- Completed on 2023-09-15 18:44:27

--
-- PostgreSQL database dump complete
--

-- Completed on 2023-09-15 18:44:27

--
-- PostgreSQL database cluster dump complete
--


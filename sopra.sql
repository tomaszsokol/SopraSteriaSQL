--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: values; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."values" (
    operation text,
    amount integer
);


ALTER TABLE public."values" OWNER TO postgres;

--
-- Data for Name: values; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."values" (operation, amount) FROM stdin;
supply	123
buy	17
buy	5
buy	28
supply	30
buy	38
supply	19
buy	24
\.


--
-- PostgreSQL database dump complete
--


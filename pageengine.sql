--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: pages; Type: TABLE; Schema: public; Owner: testuser; Tablespace: 
--

CREATE TABLE pages (
    id character varying(255) NOT NULL,
    parentid character varying(255),
    title character varying(255),
    title4menu character varying(255),
    keywords character varying(255),
    description character varying(255),
    maintext text
);


ALTER TABLE public.pages OWNER TO testuser;

--
-- Data for Name: pages; Type: TABLE DATA; Schema: public; Owner: testuser
--

COPY pages (id, parentid, title, title4menu, keywords, description, maintext) FROM stdin;
main	\N	main	main	main key	main desc	main text
history	main	new history	history	history one	history one	<h1> History </h1>\r\nЭто маленькая история о известном человеке\r\nОбщий раздел
history2	history	History two	history 2	asd		<b>history2</b>
newest	main	newest	newest	a		<br>\r\nСамая новая страница!!!!\r\n<br>\r\n<b> Good buy</b>
\.


--
-- Name: pages_pkey; Type: CONSTRAINT; Schema: public; Owner: testuser; Tablespace: 
--

ALTER TABLE ONLY pages
    ADD CONSTRAINT pages_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--


--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

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
-- Name: Produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Produit" (
    id integer NOT NULL,
    description character varying(250),
    prix double precision,
    "qteStock" integer,
    "nbrVote" integer,
    intitule character varying(50),
    "urlImage" character varying(250)
);


ALTER TABLE public."Produit" OWNER TO postgres;

--
-- Name: Produit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Produit" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Produit_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: Session; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Session" (
    id integer NOT NULL,
    "idUtilisateur" integer,
    hash character varying(32)
);


ALTER TABLE public."Session" OWNER TO postgres;

--
-- Name: Utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Utilisateur" (
    nom character varying(50),
    prenom character varying(50),
    email character varying(50),
    password character varying(25),
    "nivDroit" integer,
    salt character varying(64),
    ville character varying(64),
    id integer NOT NULL
);


ALTER TABLE public."Utilisateur" OWNER TO postgres;

--
-- Name: Utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Utilisateur_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Utilisateur_id_seq" OWNER TO postgres;

--
-- Name: Utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Utilisateur_id_seq" OWNED BY public."Utilisateur".id;


--
-- Name: Vote_Produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Vote_Produit" (
    "idProduit" integer NOT NULL,
    "idUtilisateur" integer NOT NULL,
    "dateVote" date
);


ALTER TABLE public."Vote_Produit" OWNER TO postgres;

--
-- Name: Utilisateur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur" ALTER COLUMN id SET DEFAULT nextval('public."Utilisateur_id_seq"'::regclass);


--
-- Name: Produit Produit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Produit"
    ADD CONSTRAINT "Produit_pkey" PRIMARY KEY (id);


--
-- Name: Session Session_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Session"
    ADD CONSTRAINT "Session_pkey" PRIMARY KEY (id);


--
-- Name: Utilisateur Utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT "Utilisateur_pkey" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--


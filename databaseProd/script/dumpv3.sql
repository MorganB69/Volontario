--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-03-19 11:54:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 25334)
-- Name: adresse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresse (
    id_adresse integer NOT NULL,
    voie character varying NOT NULL,
    code character varying NOT NULL,
    commune character varying NOT NULL,
    departement character varying NOT NULL
);


ALTER TABLE public.adresse OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 25340)
-- Name: adresse_id_adresse_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.adresse_id_adresse_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.adresse_id_adresse_seq OWNER TO postgres;

--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 197
-- Name: adresse_id_adresse_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.adresse_id_adresse_seq OWNED BY public.adresse.id_adresse;


--
-- TOC entry 198 (class 1259 OID 25342)
-- Name: asso_domaine; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asso_domaine (
    id_domaine integer NOT NULL,
    id_association integer NOT NULL
);


ALTER TABLE public.asso_domaine OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 25345)
-- Name: association; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.association (
    id_association integer NOT NULL,
    nom character varying NOT NULL,
    web character varying,
    siret character varying NOT NULL,
    description character varying NOT NULL,
    photo character varying DEFAULT 'photodef.jpg'::character varying NOT NULL,
    id_adresse integer NOT NULL
);


ALTER TABLE public.association OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 25351)
-- Name: association_id_association_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.association_id_association_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.association_id_association_seq OWNER TO postgres;

--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 200
-- Name: association_id_association_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.association_id_association_seq OWNED BY public.association.id_association;


--
-- TOC entry 201 (class 1259 OID 25353)
-- Name: benevole; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.benevole (
    id_benevole integer NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    id_adresse integer NOT NULL
);


ALTER TABLE public.benevole OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25359)
-- Name: benevole_id_benevole_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.benevole_id_benevole_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.benevole_id_benevole_seq OWNER TO postgres;

--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 202
-- Name: benevole_id_benevole_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.benevole_id_benevole_seq OWNED BY public.benevole.id_benevole;


--
-- TOC entry 203 (class 1259 OID 25361)
-- Name: benevole_inscription; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.benevole_inscription (
    id_benevole integer NOT NULL,
    id_inscription integer NOT NULL
);


ALTER TABLE public.benevole_inscription OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 25364)
-- Name: domaine; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.domaine (
    id_domaine integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.domaine OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 25370)
-- Name: domaine_id_domaine_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.domaine_id_domaine_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.domaine_id_domaine_seq OWNER TO postgres;

--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 205
-- Name: domaine_id_domaine_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.domaine_id_domaine_seq OWNED BY public.domaine.id_domaine;


--
-- TOC entry 206 (class 1259 OID 25372)
-- Name: inscription; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inscription (
    id_inscription integer NOT NULL,
    nbplaces integer NOT NULL,
    debut timestamp without time zone NOT NULL,
    fin timestamp without time zone NOT NULL,
    id_mission integer NOT NULL
);


ALTER TABLE public.inscription OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 25375)
-- Name: inscription_id_inscription_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inscription_id_inscription_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inscription_id_inscription_seq OWNER TO postgres;

--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 207
-- Name: inscription_id_inscription_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inscription_id_inscription_seq OWNED BY public.inscription.id_inscription;


--
-- TOC entry 208 (class 1259 OID 25377)
-- Name: mission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mission (
    id_mission integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL,
    complement character varying,
    competence character varying NOT NULL,
    id_association integer NOT NULL,
    id_adresse integer NOT NULL,
    id_domaine integer NOT NULL
);


ALTER TABLE public.mission OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 25383)
-- Name: mission_id_mission_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mission_id_mission_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mission_id_mission_seq OWNER TO postgres;

--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 209
-- Name: mission_id_mission_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mission_id_mission_seq OWNED BY public.mission.id_mission;


--
-- TOC entry 211 (class 1259 OID 25473)
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_utilisateur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_utilisateur_seq OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25465)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id_utilisateur integer DEFAULT nextval('public.utilisateur_id_utilisateur_seq'::regclass) NOT NULL,
    identifiant character varying NOT NULL,
    mdp character varying NOT NULL,
    mail character varying NOT NULL,
    role character varying NOT NULL,
    id_benevole integer,
    id_association integer
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 2735 (class 2604 OID 25385)
-- Name: adresse id_adresse; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse ALTER COLUMN id_adresse SET DEFAULT nextval('public.adresse_id_adresse_seq'::regclass);


--
-- TOC entry 2736 (class 2604 OID 25386)
-- Name: association id_association; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.association ALTER COLUMN id_association SET DEFAULT nextval('public.association_id_association_seq'::regclass);


--
-- TOC entry 2738 (class 2604 OID 25387)
-- Name: benevole id_benevole; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole ALTER COLUMN id_benevole SET DEFAULT nextval('public.benevole_id_benevole_seq'::regclass);


--
-- TOC entry 2739 (class 2604 OID 25389)
-- Name: inscription id_inscription; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscription ALTER COLUMN id_inscription SET DEFAULT nextval('public.inscription_id_inscription_seq'::regclass);


--
-- TOC entry 2740 (class 2604 OID 25390)
-- Name: mission id_mission; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission ALTER COLUMN id_mission SET DEFAULT nextval('public.mission_id_mission_seq'::regclass);


--
-- TOC entry 2895 (class 0 OID 25334)
-- Dependencies: 196
-- Data for Name: adresse; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adresse (id_adresse, voie, code, commune, departement) FROM stdin;
7	7 Rue d'Oran	31600	Muret	31, Haute-Garonne, Occitanie (Midi-Pyrénées)
23	3 Rue Jean Zay	69800	Saint-Priest	69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)
28	36 Rue Marietton	69009	Lyon	69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)
29	3 Rue de la République	69001	Lyon	69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)
30	Rue du Président Édouard Herriot	69002	Lyon	69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)
1	rue Marietton	69009	Muret	31, Haute-Garonne, Occitanie (Midi-Pyrénées)
2	rue Massena	69001	Lyon	69, Rhône, Auvergne-Rhône-Alpes (Rhône-Alpes)
3	rue de la République	69002	Muret	31, Haute-Garonne, Occitanie (Midi-Pyrénées)
\.


--
-- TOC entry 2897 (class 0 OID 25342)
-- Dependencies: 198
-- Data for Name: asso_domaine; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asso_domaine (id_domaine, id_association) FROM stdin;
1	1
2	2
2	6
1	22
\.


--
-- TOC entry 2898 (class 0 OID 25345)
-- Dependencies: 199
-- Data for Name: association; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.association (id_association, nom, web, siret, description, photo, id_adresse) FROM stdin;
1	test	test.com	test	test	test.jpg	1
2	test	test.com	test	test	test.jpg	2
6	ASS SOUTIEN SCOLAIRE AIDE AUX DEVOIRS	\N	83056495100010	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tristique enim non ultricies posuere. Nulla non vestibulum massa, in vulputate justo. Sed posuere vitae urna et malesuada. Etiam et dictum enim. Vestibulum ut risus in quam pulvinar venenatis. Nam euismod, orci id vestibulum suscipit, est sapien pellentesque neque, at mollis elit turpis at dolor. Nullam lobortis aliquet metus, et lobortis tellus ornare eu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur euismod erat quis metus pharetra ornare. Aenean lobortis malesuada massa at rutrum. Donec quis turpis purus. Nulla facilisis metus non semper elementum. Phasellus tincidunt erat a ex dignissim, ac condimentum nisi sollicitudin. Sed accumsan in erat id sodales. Praesent nec laoreet mauris.\n\nDonec massa lacus, varius vitae consequat vel, molestie in ante. Nam molestie urna sed purus mattis malesuada. Nullam maximus accumsan nulla nec tincidunt. Pellentesque porttitor tristique posuere. Fusce dictum dignissim congue. Nam vestibulum ipsum sit amet ex egestas, sed scelerisque massa aliquam. Etiam non nisl non felis vulputate efficitur consectetur eget urna. Pellentesque magna elit, accumsan nec sodales ac, volutpat rhoncus metus.\n\nSed nec luctus lorem. Vivamus tincidunt turpis magna, sed semper diam hendrerit quis. Sed feugiat nisi massa. Phasellus id ligula eu sem ultrices dapibus quis et urna. Proin sagittis dignissim ex, nec vulputate purus pretium a. Sed condimentum orci neque, sit amet sodales sem facilisis at. Phasellus nibh quam, maximus ut magna quis, vulputate gravida magna. Nulla facilisi. Integer vitae magna tincidunt, tempor enim eu, rhoncus ipsum. Cras vel luctus felis. Maecenas finibus quam ac sapien bibendum auctor. Phasellus finibus feugiat augue, sit amet efficitur metus convallis id. Praesent vehicula faucibus varius. Ut nec sagittis diam. Fusce pulvinar, velit et iaculis hendrerit, tortor turpis posuere risus, in rhoncus dui eros nec lacus. Etiam a aliquam eros, id commodo felis.\n\nPraesent ultrices diam lectus, ut sollicitudin nibh sollicitudin vel. Cras faucibus odio eros, aliquam ullamcorper neque elementum at. Etiam in nulla id libero mattis condimentum. Morbi laoreet ligula dictum massa consectetur fringilla. Pellentesque mauris dolor, aliquet id ipsum sit amet, tincidunt pharetra ipsum. Curabitur pretium leo sit amet faucibus pulvinar. Aenean vulputate, turpis elementum dapibus vestibulum, lacus odio pharetra metus, eu sollicitudin nulla justo in nibh. Pellentesque at mauris porta, tempus massa quis, ultrices mauris. Donec gravida turpis quam, non rhoncus felis suscipit eget. Phasellus vitae tellus dolor. Cras tempus semper massa ac aliquam. Fusce semper augue eu enim convallis, imperdiet ullamcorper enim gravida. Etiam mollis vestibulum enim eget dignissim. Nunc id magna interdum, ultrices felis interdum, dictum erat. Integer a semper quam, ut rutrum felis. Aliquam aliquet egestas ultrices.\n\nDonec lacinia blandit erat ac tristique. Quisque vel nulla tincidunt, congue tellus ut, cursus nibh. Nam accumsan mattis ante, et feugiat elit laoreet vel. Donec tempus at enim vel tempor. Ut venenatis lobortis justo id hendrerit. Praesent consectetur nisi ac lectus maximus consectetur. Proin pharetra ante ut sodales sodales. Aenean a nunc neque. Pellentesque condimentum ultrices nisi. Donec ac mollis magna. Cras a venenatis arcu, vel lacinia elit. Morbi vel augue efficitur, auctor erat a, ornare nunc. Maecenas urna purus, tristique ac rhoncus et, commodo ac metus. Ut lorem purus, facilisis ut aliquam nec, elementum eu lectus.	associations.jpg	7
22	HCL TECHNOLOGIES FRANCE	azer.com	53082863100040	Test	photodef.jpg	23
\.


--
-- TOC entry 2900 (class 0 OID 25353)
-- Dependencies: 201
-- Data for Name: benevole; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.benevole (id_benevole, nom, prenom, id_adresse) FROM stdin;
1	Brighi	Morgan	1
3	Dupond	Jean	28
4	Pardi	Carole	29
5	Dupré	Paul	30
\.


--
-- TOC entry 2902 (class 0 OID 25361)
-- Dependencies: 203
-- Data for Name: benevole_inscription; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.benevole_inscription (id_benevole, id_inscription) FROM stdin;
1	1
3	1
1	2
\.


--
-- TOC entry 2903 (class 0 OID 25364)
-- Dependencies: 204
-- Data for Name: domaine; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.domaine (id_domaine, nom, description) FROM stdin;
1	Aide aux personnes âgées	Aide aux personnes âgées
2	Soutien scolaire	Soutien scolaire pour les jeunes en difficulté
\.


--
-- TOC entry 2905 (class 0 OID 25372)
-- Dependencies: 206
-- Data for Name: inscription; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inscription (id_inscription, nbplaces, debut, fin, id_mission) FROM stdin;
1	2	2019-01-22 19:10:00	2019-01-22 20:30:00	1
4	2	2019-01-22 16:05:00	2019-01-22 17:05:00	3
3	2	2019-01-22 15:05:00	2019-01-22 17:05:00	2
2	3	2019-01-22 11:05:00	2019-01-22 12:05:00	1
\.


--
-- TOC entry 2907 (class 0 OID 25377)
-- Dependencies: 208
-- Data for Name: mission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mission (id_mission, nom, description, complement, competence, id_association, id_adresse, id_domaine) FROM stdin;
1	Assistante Maison Retraite	La mission consiste à aider des personnes âgées dans une maison de retraite	\N	Pas de compétence particulière	6	1	1
2	Soutien scolaire 6ème	La mission consiste à offrir du soutien scolaire à des élèves de 6 èmes	\N	Niveau scolaire adéquate	22	2	2
3	Assistance à domicile	La mission consiste à aller chez une personne âgée afin de l'assister.	\N	Pouvoir se déplacer facilement	6	1	1
\.


--
-- TOC entry 2909 (class 0 OID 25465)
-- Dependencies: 210
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id_utilisateur, identifiant, mdp, mail, role, id_benevole, id_association) FROM stdin;
6	Hcltechnologies	$2a$10$Wzt8gcdNbziL2LTrNK/y5OI6TR9IBdagj7Xj9nbdeyEJgyeCLyzjG	azeaz.morgan@gmail.com	ASSO	\N	22
1	Morgan	$2a$10$Wzt8gcdNbziL2LTrNK/y5OI6TR9IBdagj7Xj9nbdeyEJgyeCLyzjG	brighi.morgan@gmail.fr	BENE	1	\N
7	Jean	$2a$10$fMm8r8WyCLvO03FR4MJlnO2SN37DGhwcPcxh6EaFKsWrhGbJdq0Y2	jean@gmail.fr	BENE	3	\N
8	Carole	$2a$10$7skqOKz0uu/YT0xhuqHWeOu0URj8Io5v2whnvYGMVYFNQBNNkPHy6	carole@gmail.fr	BENE	4	\N
9	Paul	$2a$10$b3O6xfqfaoZa2RS9HWCkeO3XZkHVOnFUJYBYZldPWdTq6fOBhJaBC	paul@gmail.fr	BENE	5	\N
\.


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 197
-- Name: adresse_id_adresse_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.adresse_id_adresse_seq', 30, true);


--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 200
-- Name: association_id_association_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.association_id_association_seq', 22, true);


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 202
-- Name: benevole_id_benevole_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.benevole_id_benevole_seq', 5, true);


--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 205
-- Name: domaine_id_domaine_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.domaine_id_domaine_seq', 1, false);


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 207
-- Name: inscription_id_inscription_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inscription_id_inscription_seq', 1, false);


--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 209
-- Name: mission_id_mission_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mission_id_mission_seq', 4, true);


--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 211
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_utilisateur_seq', 9, true);


--
-- TOC entry 2743 (class 2606 OID 25392)
-- Name: adresse adresse_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT adresse_pk PRIMARY KEY (id_adresse);


--
-- TOC entry 2745 (class 2606 OID 25394)
-- Name: asso_domaine asso_domaine_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asso_domaine
    ADD CONSTRAINT asso_domaine_pk PRIMARY KEY (id_domaine, id_association);


--
-- TOC entry 2747 (class 2606 OID 25396)
-- Name: association association_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.association
    ADD CONSTRAINT association_pk PRIMARY KEY (id_association);


--
-- TOC entry 2751 (class 2606 OID 25398)
-- Name: benevole_inscription benevole_inscription_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole_inscription
    ADD CONSTRAINT benevole_inscription_pk PRIMARY KEY (id_benevole, id_inscription);


--
-- TOC entry 2749 (class 2606 OID 25400)
-- Name: benevole benevole_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole
    ADD CONSTRAINT benevole_pk PRIMARY KEY (id_benevole);


--
-- TOC entry 2753 (class 2606 OID 25402)
-- Name: domaine domaine_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.domaine
    ADD CONSTRAINT domaine_pk PRIMARY KEY (id_domaine);


--
-- TOC entry 2755 (class 2606 OID 25404)
-- Name: inscription inscription_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscription
    ADD CONSTRAINT inscription_pk PRIMARY KEY (id_inscription);


--
-- TOC entry 2757 (class 2606 OID 25406)
-- Name: mission mission_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT mission_pk PRIMARY KEY (id_mission);


--
-- TOC entry 2761 (class 2606 OID 25472)
-- Name: utilisateur user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT user_pk PRIMARY KEY (id_utilisateur);


--
-- TOC entry 2758 (class 1259 OID 25487)
-- Name: fki_user_association_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_association_fk ON public.utilisateur USING btree (id_association);


--
-- TOC entry 2759 (class 1259 OID 25481)
-- Name: fki_user_benevole_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user_benevole_fk ON public.utilisateur USING btree (id_benevole);


--
-- TOC entry 2764 (class 2606 OID 25407)
-- Name: association adresse_association_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.association
    ADD CONSTRAINT adresse_association_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);


--
-- TOC entry 2765 (class 2606 OID 25412)
-- Name: benevole adresse_benevole_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole
    ADD CONSTRAINT adresse_benevole_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);


--
-- TOC entry 2769 (class 2606 OID 25417)
-- Name: mission adresse_mission_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT adresse_mission_fk FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);


--
-- TOC entry 2762 (class 2606 OID 25422)
-- Name: asso_domaine association_asso_domaine_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asso_domaine
    ADD CONSTRAINT association_asso_domaine_fk FOREIGN KEY (id_association) REFERENCES public.association(id_association);


--
-- TOC entry 2770 (class 2606 OID 25427)
-- Name: mission association_mission_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT association_mission_fk FOREIGN KEY (id_association) REFERENCES public.association(id_association);


--
-- TOC entry 2766 (class 2606 OID 25432)
-- Name: benevole_inscription benevole_benevole_inscription_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole_inscription
    ADD CONSTRAINT benevole_benevole_inscription_fk FOREIGN KEY (id_benevole) REFERENCES public.benevole(id_benevole);


--
-- TOC entry 2763 (class 2606 OID 25437)
-- Name: asso_domaine domaine_asso_domaine_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asso_domaine
    ADD CONSTRAINT domaine_asso_domaine_fk FOREIGN KEY (id_domaine) REFERENCES public.domaine(id_domaine);


--
-- TOC entry 2771 (class 2606 OID 25442)
-- Name: mission domaine_mission_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mission
    ADD CONSTRAINT domaine_mission_fk FOREIGN KEY (id_domaine) REFERENCES public.domaine(id_domaine);


--
-- TOC entry 2767 (class 2606 OID 25447)
-- Name: benevole_inscription inscription_benevole_inscription_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.benevole_inscription
    ADD CONSTRAINT inscription_benevole_inscription_fk FOREIGN KEY (id_inscription) REFERENCES public.inscription(id_inscription);


--
-- TOC entry 2768 (class 2606 OID 25452)
-- Name: inscription mission_inscription_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscription
    ADD CONSTRAINT mission_inscription_fk FOREIGN KEY (id_mission) REFERENCES public.mission(id_mission);


--
-- TOC entry 2773 (class 2606 OID 25482)
-- Name: utilisateur user_association_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT user_association_fk FOREIGN KEY (id_association) REFERENCES public.association(id_association);


--
-- TOC entry 2772 (class 2606 OID 25476)
-- Name: utilisateur user_benevole_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT user_benevole_fk FOREIGN KEY (id_benevole) REFERENCES public.benevole(id_benevole);


-- Completed on 2019-03-19 11:54:38

--
-- PostgreSQL database dump complete
--


PGDMP         #                z            Usuario    13.6    13.6     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16483    Usuario    DATABASE     e   CREATE DATABASE "Usuario" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Usuario";
                postgres    false            �            1259    16486    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    identificacion character varying(255),
    nombre character varying(255),
    telefono character varying(255)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    16484    usuarios_id_seq    SEQUENCE     x   CREATE SEQUENCE public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public          postgres    false    201            �           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public          postgres    false    200            #           2604    16489    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            �          0    16486    usuarios 
   TABLE DATA           H   COPY public.usuarios (id, identificacion, nombre, telefono) FROM stdin;
    public          postgres    false    201   �
       �           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 4, true);
          public          postgres    false    200            %           2606    16494    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    201            �   j   x��;�0 ��>EN����xd�`eb�D�J(� 8=dz�Rd�c���J�ǳ}A�D��;*M�~jO�:�[�Dh)�n��_��h���[���[�����n     
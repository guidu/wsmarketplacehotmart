-- Database: marketplacehotmart
/*DROP DATABASE marketplacehotmart;

CREATE DATABASE marketplacehotmart
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;*/

INSERT INTO public.tbcategoryproduct(name)
	VALUES ('business');
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('entertainment');	
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('general');		
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('health');
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('science');
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('sports');	
INSERT INTO public.tbcategoryproduct(name)
	VALUES ('technology');
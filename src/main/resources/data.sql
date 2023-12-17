INSERT INTO dictionary_en
    (expression)
VALUES ('apple'),
       ('banana'),
       ('car'),
       ('dog'),
       ('house'),
       ('computer'),
       ('book'),
       ('table'),
       ('pencil'),
       ('chair'),
       ('flower'),
       ('shoe'),
       ('cat'),
       ('bird'),
       ('phone'),
       ('window'),
       ('door'),
       ('teacher'),
       ('student'),
       ('pen'),
       ('bicycle'),
       ('lamp'),
       ('tree'),
       ('road'),
       ('river'),
       ('ball'),
       ('shirt'),
       ('hat'),
       ('watch'),
       ('sister'),
       ('brother'),
       ('friend'),
       ('mother'),
       ('father'),
       ('child'),
       ('bed'),
       ('glass'),
       ('pen'),
       ('car'),
       ('bike'),
       ('table'),
       ('phone'),
       ('computer'),
       ('bag'),
       ('hat'),
       ('orange'),
       ('desk'),
       ('window'),
       ('lamp'),
       ('clock'),
       ('chair'),
       ('hat'),
       ('shoe'),
       ('sock'),
       ('guitar'),
       ('headphones'),
       ('kitchen'),
       ('spoon'),
       ('fork'),
       ('knife'),
       ('plate'),
       ('cup'),
       ('bedroom'),
       ('bathroom'),
       ('library'),
       ('office'),
       ('hospital'),
       ('toothbrush'),
       ('toothpaste'),
       ('shower'),
       ('soap'),
       ('towel'),
       ('mirror'),
       ('keyboard'),
       ('mouse'),
       ('screen'),
       ('bookshelf'),
       ('doorbell'),
       ('couch'),
       ('blanket'),
       ('pillow'),
       ('cabinet'),
       ('painting'),
       ('vase'),
       ('garden'),
       ('flowerpot'),
       ('microwave'),
       ('refrigerator'),
       ('oven'),
       ('dining table'),
       ('candle'),
       ('remote control'),
       ('keyboard'),
       ('television');

INSERT INTO dictionary_pl (expression)
VALUES ('jabłko'),
       ('banan'),
       ('samochód'),
       ('pies'),
       ('dom'),
       ('komputer'),
       ('książka'),
       ('stół'),
       ('ołówek'),
       ('krzesło'),
       ('kwiat'),
       ('but'),
       ('kot'),
       ('ptak'),
       ('telefon'),
       ('okno'),
       ('drzwi'),
       ('nauczyciel'),
       ('uczeń'),
       ('długopis'),
       ('rower'),
       ('lampa'),
       ('drzewo'),
       ('droga'),
       ('rzeka'),
       ('piłka'),
       ('koszula'),
       ('kapelusz'),
       ('zegarek'),
       ('siostra'),
       ('brat'),
       ('przyjaciel'),
       ('matka'),
       ('ojciec'),
       ('dziecko'),
       ('łóżko'),
       ('szkło'),
       ('długopis'),
       ('samochód'),
       ('rower'),
       ('stół'),
       ('telefon'),
       ('komputer'),
       ('torba'),
       ('kapelusz'),
       ('pomarańcza'),
       ('biurko'),
       ('okno'),
       ('lampa'),
       ('zegar'),
       ('krzesło'),
       ('kapelusz'),
       ('but'),
       ('skarpetka'),
       ('gitara'),
       ('słuchawki'),
       ('kuchnia'),
       ('łyżka'),
       ('widelec'),
       ('nóż'),
       ('talerz'),
       ('kubek'),
       ('sypialnia'),
       ('łazienka'),
       ('biblioteka'),
       ('biuro'),
       ('szpital'),
       ('szczoteczka do zębów'),
       ('pasta do zębów'),
       ('prysznic'),
       ('mydło'),
       ('ręcznik'),
       ('lustro'),
       ('klawiatura'),
       ('myszka'),
       ('ekran'),
       ('półka na książki'),
       ('dzwonek do drzwi'),
       ('kanapa'),
       ('koc'),
       ('poduszka'),
       ('szafka'),
       ('obraz'),
       ('wazon'),
       ('ogród'),
       ('kwietnik'),
       ('mikrofalówka'),
       ('lodówka'),
       ('piekarnik'),
       ('stół jadalniany'),
       ('świeca'),
       ('pilot zdalnego sterowania'),
       ('klawiatura'),
       ('telewizor');

INSERT INTO dictionary_es (expression)
VALUES ('manzana'),
       ('plátano'),
       ('coche'),
       ('perro'),
       ('casa'),
       ('computadora'),
       ('libro'),
       ('mesa'),
       ('lápiz'),
       ('silla'),
       ('flor'),
       ('zapato'),
       ('gato'),
       ('pájaro'),
       ('teléfono'),
       ('ventana'),
       ('puerta'),
       ('profesor'),
       ('estudiante'),
       ('bolígrafo'),
       ('bicicleta'),
       ('lámpara'),
       ('árbol'),
       ('carretera'),
       ('río'),
       ('pelota'),
       ('camisa'),
       ('sombrero'),
       ('reloj'),
       ('hermana'),
       ('hermano'),
       ('amigo'),
       ('madre'),
       ('padre'),
       ('niño'),
       ('cama'),
       ('vaso'),
       ('coche'),
       ('bicicleta'),
       ('mesa'),
       ('teléfono'),
       ('computadora'),
       ('bolso'),
       ('sombrero'),
       ('naranja'),
       ('escritorio'),
       ('ventana'),
       ('lámpara'),
       ('reloj'),
       ('silla'),
       ('sombrero'),
       ('zapato'),
       ('calcetín'),
       ('guitarr'),
       ('auriculares'),
       ('cocina'),
       ('cuchara'),
       ('tenedor'),
       ('cuchillo'),
       ('plato'),
       ('taza'),
       ('dormitorio'),
       ('baño'),
       ('biblioteca'),
       ('oficina'),
       ('hospital'),
       ('cepillo de dientes'),
       ('pasta de dientes'),
       ('ducha'),
       ('jabón'),
       ('toalla'),
       ('espejo'),
       ('teclado'),
       ('ratón'),
       ('pantalla'),
       ('estante de libros'),
       ('timbre de la puerta'),
       ('sofá'),
       ('manta'),
       ('almohada'),
       ('armario'),
       ('pintura'),
       ('jarrón'),
       ('jardín'),
       ('maceta'),
       ('microondas'),
       ('nevera'),
       ('horno'),
       ('mesa de comedor'),
       ('vela'),
       ('control remoto'),
       ('teclado'),
       ('televisión');

INSERT INTO category (symbol)
VALUES ('fruit'),
       ('vehicle'),
       ('animal'),
       ('building'),
       ('electronics'),
       ('literature'),
       ('furniture'),
       ('stationery'),
       ('plant'),
       ('clothing'),
       ('profession'),
       ('person'),
       ('infrastructure'),
       ('geography'),
       ('sport'),
       ('accessory'),
       ('family'),
       ('relationship'),
       ('time'),
       ('room'),
       ('utensil'),
       ('dishware'),
       ('place'),
       ('hygiene'),
       ('bedding'),
       ('art'),
       ('decor'),
       ('outdoors'),
       ('gardening'),
       ('appliances'),
       ('a1');

INSERT INTO dictionary_en_categories(categories_id, dictionary_en_id)
VALUES (1, 1),
       (31, 1),
       (1, 2),
       (31, 2),
       (2, 3),
       (31, 3),
       (3, 4),
       (31, 4),
       (4, 5),
       (31, 5),
       (5, 6),
       (31, 6),
       (6, 7),
       (31, 7),
       (7, 8),
       (31, 8),
       (8, 9),
       (31, 9),
       (7, 10),
       (31, 10),
       (9, 11),
       (31, 11),
       (10, 12),
       (31, 12),
       (3, 13),
       (31, 13),
       (3, 14),
       (31, 14),
       (5, 15),
       (31, 15),
       (4, 16),
       (31, 16),
       (4, 17),
       (31, 17),
       (11, 18),
       (31, 18),
       (12, 19),
       (31, 19),
       (8, 20),
       (31, 20);

INSERT INTO dictionary_pl_categories(categories_id, dictionary_pl_id)
VALUES (1, 1),
       (31, 1),
       (1, 2),
       (31, 2),
       (2, 3),
       (31, 3),
       (3, 4),
       (31, 4),
       (4, 5),
       (31, 5),
       (5, 6),
       (31, 6),
       (6, 7),
       (31, 7),
       (7, 8),
       (31, 8),
       (8, 9),
       (31, 9),
       (7, 10),
       (31, 10),
       (9, 11),
       (31, 11),
       (10, 12),
       (31, 12),
       (3, 13),
       (31, 13),
       (3, 14),
       (31, 14),
       (5, 15),
       (31, 15),
       (4, 16),
       (31, 16),
       (4, 17),
       (31, 17),
       (11, 18),
       (31, 18),
       (12, 19),
       (31, 19),
       (8, 20),
       (31, 20);

INSERT INTO dictionary_es_categories(categories_id, dictionary_es_id)
VALUES (1, 1),
       (31, 1),
       (1, 2),
       (31, 2),
       (2, 3),
       (31, 3),
       (3, 4),
       (31, 4),
       (4, 5),
       (31, 5),
       (5, 6),
       (31, 6),
       (6, 7),
       (31, 7),
       (7, 8),
       (31, 8),
       (8, 9),
       (31, 9),
       (7, 10),
       (31, 10),
       (9, 11),
       (31, 11),
       (10, 12),
       (31, 12),
       (3, 13),
       (31, 13),
       (3, 14),
       (31, 14),
       (5, 15),
       (31, 15),
       (4, 16),
       (31, 16),
       (4, 17),
       (31, 17),
       (11, 18),
       (31, 18),
       (12, 19),
       (31, 19),
       (8, 20),
       (31, 20);

INSERT INTO translation_en_pl(expression_source_id, expression_target_id)
VALUES (1, 1),
       (2, 2);
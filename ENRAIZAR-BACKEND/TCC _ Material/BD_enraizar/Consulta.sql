CREATE TABLE calendario_emocoes (
    id_calendario INT NOT NULL,                     -- Data de referência
    id_emocao INT NOT NULL,                         -- Emoção escolhida
    observacao VARCHAR(200) DEFAULT NULL,           -- comentário do colaborador
    PRIMARY KEY (id_calendario, id_emocao),         -- Evita duplicidade 
    FOREIGN KEY (id_calendario) REFERENCES calendario(id_calendario) ON DELETE CASCADE,
    FOREIGN KEY (id_emocao) REFERENCES emocoes(id_emocao) ON DELETE CASCADE
);

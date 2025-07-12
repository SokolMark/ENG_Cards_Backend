DROP TABLE IF EXISTS Word_set;
DROP TABLE IF EXISTS Word;
DROP TABLE IF EXISTS Answer;

CREATE TABLE word_set (
                          set_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL
);

CREATE TABLE word (
                      word_id SERIAL PRIMARY KEY,
                      eng_word VARCHAR(100) NOT NULL,
                      ua_word VARCHAR(100) NOT NULL,
                      set_id INTEGER NOT NULL,
                      FOREIGN KEY (set_id) REFERENCES word_set(set_id) ON DELETE CASCADE
);

CREATE TABLE Answer(
                       answer_id SERIAL PRIMARY KEY,
                       answer INTEGER NOT NULL,
                       word_id INTEGER NOT NULL,
                       FOREIGN KEY (word_id) REFERENCES Word(word_id) ON DELETE CASCADE
);

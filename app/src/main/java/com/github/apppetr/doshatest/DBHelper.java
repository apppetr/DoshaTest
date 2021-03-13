package com.github.apppetr.doshatest;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private SQLiteDatabase dbase;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    private void addQuestions() {
        Question q1 = new Question("Умственная деятельность", "Быстрый беспокойный ум", "Острый интеллект, критическое мышление", "Спокойное, стабильное, плавное мышление", "");
        this.addQuestion(q1);
        Question q2 = new Question("Концентрация", "Хорошая краткосрочная концентрация", "Хорошая средняя умственная концентрация", "Хорошая способность к длительной концентрации", "");
        this.addQuestion(q2);
        Question q3 = new Question("Сновидения", "Движение, бег, полёт, прыжки", "Бурные, предприимчивые, пламенные, с элементами борьбы и агрессии", "Включают воду, облака, отношения, романтику", "");
        this.addQuestion(q3);
        Question q4 = new Question("Речь", "Быстрая, несдержанная, разговорчивый человек", "Точная, аргументированная, звучит убедительно", "Медленная, ясная, приятная, не очень разговорчив (хороший слушатель)", "");
        this.addQuestion(q4);
        Question q5 = new Question("Хобби", "Путешествия, танцы, бег, аэробика (действия)", "Спорт, политика (соревнования)", "Ходьба, чтение, работа в саду (развлечения)", "");
        this.addQuestion(q5);
        Question q6 = new Question("Память", "Хорошая краткосрочная", "Хорошая общая память", "Хорошая долгосрочная", "");
        this.addQuestion(q6);
        Question q7 = new Question("Способность познавать", "Быстрое схватывание нового", "Средняя скорость познания нового", "Медленная скорость познания нового", "");
        this.addQuestion(q7);
        Question q8 = new Question("Сон", "Поверхностный, легко прерываемый, часто просыпаетесь", "Средний, лёгкий сон, в среднем 6-8 часов", "Непрерывный длительный сон более 8 часов, трудно разбудить", "");
        this.addQuestion(q8);
        Question q9 = new Question("Голос", "Низкий, слабый, хриплый", "Сильный, громкий, высокий голос", "Глубокий, приятный тембр голоса", "");
        this.addQuestion(q9);
        Question q10 = new Question("Скорость принятия пищи", "Быстрая", "Средняя", "Медленная", "");
        this.addQuestion(q10);
        Question q11 = new Question("Еда и напитки", "Предпочитаю тёплую пищу", "Предпочитаю прохладную пищу", "Предпочитаю сухую и тёплую пищу", "");
        this.addQuestion(q11);
        Question q12 = new Question("Благотворительность/пожертвования", "Даю незначительное количество", "Ничего не даю, или даю большое количество иногда, под настроение", "Даю регулярно и великодушно", "");
        this.addQuestion(q12);
        Question q13 = new Question("Сексуальное поведение", "Переменчивый или низкий уровень активности", "Умеренный", "Сильный", "");
        this.addQuestion(q13);
        Question q14 = new Question("Аппетит", "Переменный, неустойчивый, усиливается и уменьшается", "Сильный, отчётливый, не могу при чувстве голода пропускать приём пищи", "Слабый, могу легко пропускать приём пищи", "");
        this.addQuestion(q14);
        Question q15 = new Question("Достижение целей", "Легко отвлекаюсь", "Сосредоточенный и целеустремлённый", "Двигаюсь к цели медленно и устойчиво", "");
        this.addQuestion(q15);
        Question q16 = new Question("Отношения", "Отношения чаще всего поверхностные, легко схожусь и легко расстаюсь", "Интенсивные", "Длительные и глубокие", "");
        this.addQuestion(q16);
        Question q17 = new Question("Активность", "Быстрая, нестабильная, вспышками, гиперактивная", "Точная, упорядоченная, разумная, мотивированная, целеустремлённая", "Медленная, устойчивая, расслабленная", "");
        this.addQuestion(q17);
        Question q18 = new Question("Предпочтение в погоде", "Предпочитаю тёплую и влажную погоду", "Наслаждаюсь прохладной погодой", "Любовь к сухой и тёплой погоде; отвращение, к сырой и холодной", "");
        this.addQuestion(q18);
        Question q19 = new Question("Финансы", "Не экономлю, быстро трачу", "Экономлю, но много регулярно трачу", "Экономлю, накапливаю богатство", "");
        this.addQuestion(q19);
        Question q20 = new Question("Дружба", "Имею тенденцию к краткосрочной дружбе, быстро завожу отношения", "Имею тенденцию быть одиночкой, друзья, связанные с работой", "Имею тенденцию формировать длительные дружеские отношения", "");
        this.addQuestion(q20);
        Question q21 = new Question("Настроение", "Быстро изменяется", "Медленно изменяется", "Стабильное, неизменное", "");
        this.addQuestion(q21);
        Question q22 = new Question("Более чувствительный к", "Собственным чувствам", "Не чувствительный", "Чувствам других", "");
        this.addQuestion(q22);
        Question q23 = new Question("Реакция на стресс", "Присутствует страх", "Присутствует гнев, раздражение", "Безразличие", "");
        this.addQuestion(q23);
        Question q24 = new Question("Когда угрожают, имею тенденцию", "Бежать", "Бороться", "Мириться", "");
        this.addQuestion(q24);
        Question q25 = new Question("Выражение привязанности", "Со словами", "С подарками", "С прикосновением", "");
        this.addQuestion(q25);
        Question q26 = new Question("Внутренние ощущения при возникновении проблем", "Беспокойство, волнение", "Раздражение и злость", "Спокойствие или депрессия", "");
        this.addQuestion(q26);
        Question q27 = new Question("Волосы", "Тонкие, сухие, прямые, часто с перхотью", "Умеренной толщины, изящные, тенденция к раннему облысению или поседению", "Маслянистые, толстые, чёрные, очень волнистые, глянцевитые", "");
        this.addQuestion(q27);
        Question q28 = new Question("Пальцы", "Маленькие, тонкие, сухие, холодные, шершавые, длинные тонкие пальцы", "Средние, тёплые, розоватые, влажные, умеренно остроконечные пальцы", "Большие, плотные, холодные, крепкие, толстые пальцы", "");
        this.addQuestion(q28);
        Question q29 = new Question("Цвет лица", "Тёмный, смуглый", "Розово-красный, сияющий", "Бледный, белый", "");
        this.addQuestion(q29);
        Question q30 = new Question("Кожа", "Тонкая, сухая, прохладная, шершавая, трескающаяся", "Тёплая, влажная, розовая, с родинками, с веснушками, угреватая", "Толстая, белая, влажная, холодная, нежная, гладкая", "");
        this.addQuestion(q30);
        Question q31 = new Question("Суставы", "Маленькие, тонкие, хруст в суставах", "Среднего размера, мягкие, свободные", "Большие, толстые, глубоко посаженные", "");
        this.addQuestion(q31);
        Question q32 = new Question("Глаза", "Маленькие, сухие, тонкие, коричневые; подвижный взгляд", "Среднего размера, голубые или зелёные; острый, пронзительный взгляд", "Большие, глянцевитые, маслянистые, чёрные, привлекательные", "");
        this.addQuestion(q32);
        Question q33 = new Question("Телосложение", "Толстый или худой, высокий или низкий, ткани тела недостаточно развиты", "Умеренно развитое тело, среднее телосложение", "Хорошо сложенный, плотный, коренастый", "");
        this.addQuestion(q33);
        Question q34 = new Question("Насколько легко вы потеете", "Слабо, только когда жарко", "Легко, больше чем хотелось бы", "Очень мало", "");
        this.addQuestion(q34);
        Question q35 = new Question("Размер зубов", "Очень большие или очень маленькие", "Маленькие-средние", "Средние-большие", "");
        this.addQuestion(q35);
        Question q36 = new Question("Вес", "Небольшой вес, тяжело набираю вес, и если набираю вес, то могу легко избавиться от его избытка", "Средний вес, хорошие мышцы, не могу легко набрать вес", "Избыточный вес, легко набираю вес, очень тяжело сбросить лишний вес", "");
        this.addQuestion(q36);
        Question q37 = new Question("Пищеварение", "Тенденция к запорам, сухой стул и газообразование", "Сильное пищеварение, нормальный и свободный стул", "Приём пищи один или два раза в день, хорошо сформированный стул", "");
        this.addQuestion(q37);
        Question q38 = new Question("Выносливость/Сила", "Низкая выносливость, слабое терпение, усталость после некоторой активности", "Средние показатели", "Большая выносливость, сохраняют работоспособность в течение длительного времени", "");
        this.addQuestion(q38);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}

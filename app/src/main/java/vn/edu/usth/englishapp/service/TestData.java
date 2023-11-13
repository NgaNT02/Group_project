package vn.edu.usth.englishapp.service;

import vn.edu.usth.englishapp.R;
import vn.edu.usth.englishapp.model.Category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestData {
    public static List<Category> getListCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.icon_app_oxford, "Oxford", ""));
        categories.add(new Category(R.drawable.ic_topic, "Topic", ""));
        categories.add(new Category(R.drawable.ic_3k, "3KWord", ""));
        categories.add(new Category(R.drawable.ic_quiz, "Quiz", ""));
        categories.add(new Category(R.drawable.ic_thongke, "Statistics", ""));
        categories.add(new Category(R.drawable.ic_article, "Article", ""));
        return categories;
    }

//    public static List<Vote> getVoteUsers() {
//        List<Vote> votes = new ArrayList<>();
//        votes.add(new Vote("App Đỉnh quá 100đ", 4.5f, "Đỗ Đăng Dũng", "This English learning app is excellent! It provides a wide range of engaging activities and interactive lessons that cater to different learning styles. The app's user-friendly interface makes it easy to navigate, and the audio recordings are clear and helpful for pronunciation practice. Overall, this app is a fantastic resource for anyone looking to improve their English language skills.", "1"));
//        votes.add(new Vote("App Đỉnh quá 100đ", 4.5f, "Cô Vân Anh", "This English learning app is excellent! It provides a wide range of engaging activities and interactive lessons that cater to different learning styles. The app's user-friendly interface makes it easy to navigate, and the audio recordings are clear and helpful for pronunciation practice. Overall, this app is a fantastic resource for anyone looking to improve their English language skills.", "1"));
//        votes.add(new Vote("App Đỉnh quá 100đ", 4.5f, "Các bạn", "This English learning app is excellent! It provides a wide range of engaging activities and interactive lessons that cater to different learning styles. The app's user-friendly interface makes it easy to navigate, and the audio recordings are clear and helpful for pronunciation practice. Overall, this app is a fantastic resource for anyone looking to improve their English language skills.", "1"));
//        return votes;
//    }

//    public static List<WordRecent> getWordRecent() {
//        List<WordRecent> wordRecents = new ArrayList<>();
//        wordRecents.add(new WordRecent("english", 1, ""));
//        wordRecents.add(new WordRecent("hello", 2, ""));
//        wordRecents.add(new WordRecent("hi", 3, ""));
//        wordRecents.add(new WordRecent("what", 2, ""));
//        wordRecents.add(new WordRecent("recycle", 2, ""));
//        wordRecents.add(new WordRecent("view", 2, ""));
//        wordRecents.add(new WordRecent("dung", 1, ""));
//        wordRecents.add(new WordRecent("sobin", 1, ""));
//        wordRecents.add(new WordRecent("handsome", 1, ""));
//        return wordRecents;
//    }

//    public static List<Article> getArticle() {
//        List<Article> list = new ArrayList<>();
//        list.add(new Article("Bài viết tiếng anh này rất hay", "Đây là content dài lắm", 1, new Date().getTime(), "https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg", 0));
//        list.add(new Article("Bài viết tiếng anh này rất hay", "Đây là content dài lắm", 1, new Date().getTime(), "https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg", 0));
//        list.add(new Article("Bài viết tiếng anh này rất hay", "Đây là content dài lắm", 1, new Date().getTime(), "https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg", 0));
//        return list;
//    }

//    public static List<YourWord> getYourWords() {
//        List<YourWord> list = new ArrayList<>();
////        list.add(new YourWord(1L, "Hello", "Xin chào", "Hello world", "1"));
////        list.add(new YourWord(1L, "Halo", "Xin chào", "Hello world", "1"));
////        list.add(new YourWord(1L, "Helu", "Xin chào", "Hello world", "1"));
////        list.add(new YourWord(1L, "Hi", "Xin chào", "Hello world", "1"));
////        list.add(new YourWord(1L, "Hoho", "Xin chào", "Hello world", "1"));
////        list.add(new YourWord(1L, "Huhu", "Xin chào", "Hello world", "1"));
//        return list;
//    }

//    public static List<Dic109K> getDic109KS() {
//        List<Dic109K> list = new ArrayList<>();
//        list.add(new Dic109K("Hello World", "He lô gua", "Đây là nghĩa của từ này\nHihi"));
//        list.add(new Dic109K("Hello World", "He lô gua", "Đây là nghĩa của từ này\nHihi"));
//        list.add(new Dic109K("Hello World", "He lô gua", "Đây là nghĩa của từ này\nHihi"));
//        list.add(new Dic109K("Hello World", "He lô gua", "Đây là nghĩa của từ này\nHihi"));
//        return list;
//    }

    public static String getRandomSentence() {
        String[] sentences = {
                "Hello, how are you?",
                "I love to travel.",
                "What time is it?",
                "Can you help me, please?",
                "Where is the nearest coffee shop?",
                "I enjoy playing the guitar.",
                "What's your favorite color?",
                "Do you like watching movies?",
                "Could you repeat that, please?",
                "I need to go to the supermarket.",
                "How do you pronounce this word?",
                "Let's meet at the park.",
                "I'm sorry for the mistake.",
                "Have a nice day!",
                "Where are you from?",
                "What's the weather like today?",
                "I want to improve my English.",
                "This is a beautiful place.",
                "What's your favorite food?",
                "I have a question.",
                "Nice to meet you.",
                "Can I have a glass of water, please?",
                "I'm looking for a job.",
                "Do you have any pets?",
                "What's your phone number?",
                "I enjoy listening to music.",
                "What's your favorite book?",
                "I'm going to the gym.",
                "Could you speak slower, please?",
                "I like playing soccer.",
                "Where is the restroom?",
                "What's your favorite movie?",
                "I need to make a phone call.",
                "What's your email address?",
                "I'm learning to cook.",
                "How was your day?",
                "I'm excited about the concert.",
                "Can you recommend a good restaurant?",
                "What's your favorite hobby?",
                "I'm studying English.",
                "What's the capital of France?",
                "I'm going on vacation next week.",
                "Do you have any siblings?",
                "What's your favorite sport?",
                "I'm sorry, I don't understand.",
                "What's your favorite song?",
                "I'm interested in photography.",
                "How do you spell this word?",
                "I need a doctor.",
                "What's your favorite TV show?",
                "I'm going to the beach.",
                "Can you lend me some money?",
                "What's your favorite season?",
                "I'm going shopping.",
                "What's the nearest subway station?",
                "I'm tired, I need some rest.",
                "Do you have any recommendations?",
                "What's your favorite animal?",
                "I'm going to a party tonight.",
                "Can you show me the way to the museum?",
                "What's your favorite color?",
                "I'm taking a language course.",
                "How long have you lived here?",
                "I'm going to a wedding.",
                "What's your favorite restaurant?",
                "I'm a student.",
                "Can you give me directions, please?",
                "What's your favorite holiday?",
                "I'm going to the cinema.",
                "Do you have any plans for the weekend?",
                "What's your favorite place to visit?",
                "I'm feeling tired.",
                "Can you recommend a good book?",
                "What's your favorite drink?",
                "I'm going to a concert.",
                "Do you have any hobbies?",
                "What's your favorite city?",
                "I'm studying for an exam.",
                "Can you help me with my homework?",
                "What's your favorite dessert?",
                "I'm going to a birthday party.",
                "Do you like to cook?",
                "What's your favorite type of music?",
                "I'm going for a walk in the park.",
                "Can you give me a tour of the city?",
                "What's your favorite quote?",
                "I'm attending a conference tomorrow.",
                "Do you enjoy hiking?",
                "What's your favorite season of the year?",
                "I'm going to a comedy show.",
                "Can you recommend a good movie?",
                "What's your favorite outdoor activity?",
                "I'm preparing for a presentation.",
                "Do you have any favorite quotes?",
                "What's your favorite type of cuisine?",
                "I'm going to a museum.",
                "Can you suggest a good TV series?",
                "What's your favorite hobby to do at home?",
                "I'm starting a new project.",
                "Do you enjoy gardening?",
                "What's your favorite holiday destination?",
                "I'm going to a live concert.",
                "Can you recommend a good playlist?",
                "What's your favorite type of art?",
                "I'm planning a road trip.",
                "Do you have any favorite bands or artists?",
                "What's your favorite way to relax?",
                "I'm going to a sports event.",
                "Can you suggest a good documentary?",
                "What's your favorite type of dance?",
                "I'm trying out a new recipe.",
                "Do you enjoy yoga?",
                "What's your favorite travel destination?",
                "I'm going to a theater performance.",
                "Can you recommend a good podcast?",
                "What's your favorite type of exercise?",
                "I'm volunteering for a charity.",
                "Do you enjoy meditation?",
                "What's your favorite historical place?",
                "I'm going to a music festival.",
                "Can you suggest a good novel?",
                "What's your favorite type of film genre?",
                "I'm practicing mindfulness.",
                "Do you enjoy camping?",
                "What's your favorite adventure activity?",
                "I'm going to a photography exhibition.",
                "Can you recommend a good language learning app?",
                "What's your favorite type of fashion?",
                "I'm exploring a new hobby.",
                "Do you enjoy cycling?",
                "What's your favorite beach destination?",
                "I'm going to a comedy club.",
                "Can you suggest a good motivational speaker?",
                "What's your favorite type of cuisine to cook?",
                "I'm learning a musical instrument.",
                "Do you enjoy painting?",
                "What's your favorite national park?",
                "I'm going to a poetry reading.",
                "Can you recommend a good online course?",
                "What's your favorite type of workout?",
                "I'm trying out a new sport.",
                "Do you enjoy writing?",
                "What's your favorite travel memory?",
                "I'm going to a dance performance.",
                "Can you suggest a good TED Talk?",
                "What's your favorite type of photography?",
                "I'm experimenting with a new recipe.",
                "Do you enjoy swimming?",
                "What's your favorite cultural festival?",
                "I'm going to a film premiere.",
                "Can you recommend a good motivational book?",
                "What's your favorite type of music to dance to?",
                "I'm learning a new language.",
                "Do you enjoy sculpting?",
                "What's your favorite architectural marvel?",
                "I'm going to a fashion show.",
                "Can you suggest a good self-improvement podcast?",
                "What's your favorite type of theater performance?",
                "I'm exploring different types of meditation.",
                "Do you enjoy hiking in nature?",
                "What's your favorite adrenaline-pumping activity?",
                "I'm going to a painting exhibition.",
                "Can you recommend a good coding tutorial, please?",
                "What's your favorite type of fashion style?",
                "I'm trying out a new dance style.",
                "Do you enjoy practicing martial arts?",
                "What's your favorite historical landmark?",
                "I'm going to a book signing event.",
                "Can you suggest a good motivational podcast?",
                "What's your favorite type of theater genre?",
                "I'm exploring different forms of meditation.",
                "Do you enjoy rock climbing?",
                "What's your favorite cultural tradition?",
                "I'm going to an art gallery opening.",
                "Can you recommend a good personal development book?",
                "What's your favorite type of music to relax to?",
                "I'm learning about different cultures.",
                "Do you enjoy practicing yoga?",
                "What's your favorite natural wonder?",
                "I'm going to a film festival.",
                "Can you suggest a good financial planning resource?",
                "What's your favorite type of musical genre?",
                "I'm exploring different cuisines.",
                "Do you enjoy playing team sports?",
                "What's your favorite historical period?",
                "I'm going to a theater play.",
                "Can you recommend a good motivational video?",
                "What's your favorite type of fashion accessory?",
                "I'm trying out a new workout routine.",
                "Do you enjoy horseback riding?",
                "What's your favorite architectural style?",
                "I'm going to a comedy performance.",
                "Can you suggest a good productivity tool?",
                "What's your favorite type of music to energize you?",
                "I'm learning about different art movements.",
                "Do you enjoy practicing mindfulness?",
                "What's your favorite natural landscape?",
                "I'm going to a live music gig.",
                "Can you recommend a good time management technique?",
                "What's your favorite type of theater production?",
                "I'm exploring different forms of exercise.",
                "Do you enjoy water sports?",
                "What's your favorite historical figure?",
                "I'm going to a film screening.",
                "Can you suggest a good personal growth workshop?",
                "What's your favorite type of music to sing along to?",
                "I'm learning about different culinary techniques.",
                "Do you enjoy practicing meditation?",
                "What's your favorite cultural celebration?",
                "I'm going to a fashion exhibition.",
                "Can you recommend a good motivational podcast?",
                "What's your favorite type of theater performance?",
                "I'm exploring different forms of artistic expression.",
                "Do you enjoy outdoor adventure activities?",
                "What's your favorite adrenaline-inducing sport?",
                "I'm going to an art museum.",
                "Can you suggest a good self-help book?",
                "What's your favorite type of music to unwind with?",
                "I'm learning about different philosophical ideas.",
                "Do you enjoy practicing tai chi?",
                "What's your favorite cultural festival?",
                "I'm going to a film premiere.",
                "Can you recommend a good TED Talk?",
                "What's your favorite type of photography?",
                "I'm experimenting with a new recipe.",
                "Do you enjoy swimming?",
                "What's your favorite architectural marvel?",
                "I'm going to a fashion show.",
                "Can you suggest a good self-improvement podcast?",
                "What's your favorite type of theater performance?",
                "I'm exploring different types of meditation.",
                "Do you enjoy hiking in nature?",
                "What's your favorite adrenaline-pumping activity?",
                "I'm going to a painting exhibition.",
                "Can you recommend a good coding tutorial, please?"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(sentences.length);
        String randomSentence = sentences[randomIndex];

        randomSentence = randomSentence.replaceAll("[^a-zA-Z\\s']|(?<!\\w)'|'(?![\\wllre])", "");

        return randomSentence.trim();
    }

    public static double compareSentencesPronunciation(String sentence1, String sentence2) {
        String normalizedSentence1 = normalizeSentence(sentence1);
        String normalizedSentence2 = normalizeSentence(sentence2);

        int distance = calculateLevenshteinDistance(normalizedSentence1, normalizedSentence2);
        int maxLength = Math.max(normalizedSentence1.length(), normalizedSentence2.length());

        double similarity = (1 - (double) distance / maxLength) * 100;

        return similarity;
    }

    public static String normalizeSentence(String sentence) {
        sentence = sentence.toLowerCase(); // Chuyển đổi thành chữ thường
        sentence = sentence.replaceAll("[^a-z\\s]", ""); // Loại bỏ ký tự không phải chữ cái và khoảng trắng
        sentence = sentence.replaceAll("\\s+", " "); // Chuẩn hóa khoảng trắng

        return sentence.trim();
    }

    public static int calculateLevenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static String evaluatePronunciationAccuracy(double accuracy) {
        if (accuracy == 100.0) {
            return "Xuất sắc";
        } else if (accuracy >= 90.0) {
            return "Giỏi";
        } else if (accuracy >= 80.0) {
            return "Tốt";
        } else if (accuracy >= 70.0) {
            return "Khá";
        } else if (accuracy >= 60.0) {
            return "Chưa ổn lắm";
        } else if (accuracy >= 50.0) {
            return "Trung bình";
        } else if (accuracy >= 40.0) {
            return "Dưới trung bình";
        } else if (accuracy >= 30.0) {
            return "Yếu";
        } else if (accuracy >= 20.0) {
            return "Rất yếu";
        } else if (accuracy >= 10.0) {
            return "Cực kém";
        } else {
            return "Tệ";
        }
    }
}

package com.example.moneyforquiz

object constants{
    const val username = "username"
    const val totalquestion = "10"
    const val correct = "crt"
    const val totalques = ""
    fun getques():ArrayList<questions>{
   val gquestions = ArrayList<questions>()
        //que1
        val que1 = questions(
            id = 1,"Which country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "India❤",
            1
        )
        gquestions.add(que1)
        //2
        val que2 = questions(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        gquestions.add(que2)

        // 3
        val que3 = questions(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        gquestions.add(que3)

        // 4
        val que4 = questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        gquestions.add(que4)

        // 5
        val que5 = questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        gquestions.add(que5)

        // 6
        val que6 = questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        gquestions.add(que6)

        // 7
        val que7 = questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        gquestions.add(que7)

        // 8
        val que8 = questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        gquestions.add(que8)

        // 9
        val que9 =questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        gquestions.add(que9)

        // 10
        val que10 = questions(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        gquestions.add(que10)
        return gquestions
    }
}


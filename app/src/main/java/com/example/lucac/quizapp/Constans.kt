package com.example.lucac.quizapp

object Constans {
    fun getQuestion(): ArrayList<Questions> {
        val questionlist = ArrayList<Questions>()
        //1
        val questio1 = Questions(1, "Quale tipo di linguaggio di programmazione viene utilizzato per lo sviluppo app android?",
                /*
                All values for question  image and correct answer (Kolin:1)
                 */
                R.mipmap.questionimage, "Kotlin", "CSS", "Swift", "HTML", 1)

        questionlist.add(questio1)
        //2
        val questio2 = Questions(1, "Quale componente del pc viene utilizzato per morizzare dati(cartelle, file)?",
                /*
                All values for question  image and correct answer (HDD,SSD, 3)
                 */
                R.mipmap.questionimage, "RAM", "ROM", "HHD,SSD", "GPU", 3)
        questionlist.add(questio2)
        //3
        val questio3 = Questions(1, "Da quali numeri è formato il  codice biario?",
                /*
                All values for question  image and correct answer (HDD,SSD, 3)
                 */
                R.mipmap.questionimage, "1,2", "0,1", "0", "1", 2)
        questionlist.add(questio3)
        //4
        val questio4= Questions(1, "In informatica, cos'è una variabile",
                /*
                All values for question  image and correct answer (HDD,SSD, 3)
                 */
                R.mipmap.questionimage, "Un esecuzione", "Una condizione", "Un modo per creare espression",
                "Un contenuto di informazioni", 4)
        questionlist.add(questio4)
        return questionlist
    }
}
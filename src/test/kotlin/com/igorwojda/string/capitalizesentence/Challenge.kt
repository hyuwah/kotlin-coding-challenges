package com.igorwojda.string.capitalizesentence

import com.igorwojda.utility.logExecutionTimeNano
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun capitalizeSentence(str: String, caseId: String = ""): String {
    return logExecutionTimeNano("$caseId|SolutionA") { SolutionA.capitalizeSentence(str) }
}

/**
 * Generally fastest
 */
private object SolutionA {
    fun capitalizeSentence(str: String): String {
        return str
            .split(" ") // Split into list of words
            .joinToString(" ") { word -> // map the list and join separated by " "
                word.replaceFirstChar { // self-explanatory
                    if (it.isLowerCase()) { // check to skip char that already uppercase
                        it.uppercase()
                    } else {
                        it.toString()
                    }
                }
            }
    }

}

/**
 * Generally slower than [SolutionA]
 */
private object SolutionB {
    fun capitalizeSentence(str: String): String {
        return str
            .split(" ")
            .joinToString(" ") { word ->
                word.first().uppercase() + word.substring(1) // construct capitalized word
            }
    }

}


/**
 * Generally slowest
 */
private object SolutionC {
    fun capitalizeSentence(str: String): String {
        val capitalisedWords = mutableListOf<String>()
        str.split(" ").forEach { // split the word & iterate the list
            capitalisedWords.add(
                it.first().uppercase() + it.substring(1)
            ) // add capitalised word to the new list
        }
        return capitalisedWords.joinToString(" ") // join the list to make sentence
    }

}

private class Test {
    @Test
    fun `"flower" is capitalized to "Flower"`() {
        capitalizeSentence("flower", "Case 1") shouldBeEqualTo "Flower"
    }

    @Test
    fun `"this is a house" is capitalised to "This Is A House"`() {
        capitalizeSentence("this is a house", "Case 2") shouldBeEqualTo "This Is A House"
    }

    @Test
    fun `"a b c" is capitalised to "A B C"`() {
        capitalizeSentence("a b c", "Case 3") shouldBeEqualTo "A B C"
    }

    @Test
    fun `2 paragraph of lorem ipsum should be capitalised`() {
        capitalizeSentence(
            """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eu iaculis risus. Cras sagittis ut lorem sit amet gravida. Phasellus sit amet quam sollicitudin, pulvinar urna quis, ornare tellus. Curabitur magna mauris, consectetur sed blandit quis, sodales non nibh. Etiam massa velit, dapibus quis congue et, malesuada efficitur felis. Donec lorem mi, molestie eget tempus id, porta in dui. Aliquam mollis dolor eget nibh faucibus, quis gravida sem imperdiet. Fusce faucibus, risus id vulputate volutpat, nibh elit hendrerit nibh, ac rutrum ex enim vel mauris. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut lacinia consectetur blandit. Maecenas tincidunt sagittis urna ut gravida. Vestibulum sem dolor, consectetur tempus augue quis, euismod aliquet dolor. In molestie placerat aliquet. Vestibulum ac elit quam. Nullam vel bibendum dolor. Vestibulum id fermentum elit.

            Proin quis porttitor tellus, at aliquam justo. Quisque pretium neque in leo euismod, in dictum purus porttitor. Phasellus vestibulum, libero quis pretium tincidunt, dolor sapien consectetur nisi, fermentum eleifend erat lorem sit amet odio. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi imperdiet libero non sapien sollicitudin vulputate. Pellentesque nec massa quis orci pretium porttitor auctor sit amet diam. Duis blandit risus risus, sed ullamcorper mi sodales ac. Praesent quis lorem eros. Donec luctus purus enim, vel imperdiet elit rhoncus nec. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi sodales lectus eu risus rutrum cursus. In vitae volutpat lectus. In pulvinar imperdiet neque, at facilisis ligula fermentum ut. Sed vel volutpat ex, a varius neque. Aliquam pellentesque dolor a urna mollis, sed posuere urna tincidunt.
        """.trimIndent(), "Case 4"
        ) shouldBeEqualTo """
            Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Fusce Eu Iaculis Risus. Cras Sagittis Ut Lorem Sit Amet Gravida. Phasellus Sit Amet Quam Sollicitudin, Pulvinar Urna Quis, Ornare Tellus. Curabitur Magna Mauris, Consectetur Sed Blandit Quis, Sodales Non Nibh. Etiam Massa Velit, Dapibus Quis Congue Et, Malesuada Efficitur Felis. Donec Lorem Mi, Molestie Eget Tempus Id, Porta In Dui. Aliquam Mollis Dolor Eget Nibh Faucibus, Quis Gravida Sem Imperdiet. Fusce Faucibus, Risus Id Vulputate Volutpat, Nibh Elit Hendrerit Nibh, Ac Rutrum Ex Enim Vel Mauris. Orci Varius Natoque Penatibus Et Magnis Dis Parturient Montes, Nascetur Ridiculus Mus. Ut Lacinia Consectetur Blandit. Maecenas Tincidunt Sagittis Urna Ut Gravida. Vestibulum Sem Dolor, Consectetur Tempus Augue Quis, Euismod Aliquet Dolor. In Molestie Placerat Aliquet. Vestibulum Ac Elit Quam. Nullam Vel Bibendum Dolor. Vestibulum Id Fermentum Elit.

            Proin Quis Porttitor Tellus, At Aliquam Justo. Quisque Pretium Neque In Leo Euismod, In Dictum Purus Porttitor. Phasellus Vestibulum, Libero Quis Pretium Tincidunt, Dolor Sapien Consectetur Nisi, Fermentum Eleifend Erat Lorem Sit Amet Odio. Vestibulum Ante Ipsum Primis In Faucibus Orci Luctus Et Ultrices Posuere Cubilia Curae; Morbi Imperdiet Libero Non Sapien Sollicitudin Vulputate. Pellentesque Nec Massa Quis Orci Pretium Porttitor Auctor Sit Amet Diam. Duis Blandit Risus Risus, Sed Ullamcorper Mi Sodales Ac. Praesent Quis Lorem Eros. Donec Luctus Purus Enim, Vel Imperdiet Elit Rhoncus Nec. Class Aptent Taciti Sociosqu Ad Litora Torquent Per Conubia Nostra, Per Inceptos Himenaeos. Morbi Sodales Lectus Eu Risus Rutrum Cursus. In Vitae Volutpat Lectus. In Pulvinar Imperdiet Neque, At Facilisis Ligula Fermentum Ut. Sed Vel Volutpat Ex, A Varius Neque. Aliquam Pellentesque Dolor A Urna Mollis, Sed Posuere Urna Tincidunt.
        """.trimIndent()
    }
}

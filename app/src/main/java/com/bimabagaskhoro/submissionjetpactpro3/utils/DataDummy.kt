package com.bimabagaskhoro.submissionjetpactpro3.utils

import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowRemote

object DataDummy {
   fun generateDummyMovie(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
                632357,
                "The Unholy",
                "2021-03-31",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "en",
                "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
                7.1
            )
        )

        movie.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                7.5
            )
        )

        movie.add(
            MovieEntity(
                615457,
                "Nobody",
                "2021-03-24",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "en",
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                8.4
            )
        )

        movie.add(
            MovieEntity(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "en",
                "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                8.5
            )
        )

        movie.add(
            MovieEntity(
                337404,
                "Cruella",
                "2021-05-26",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "en",
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                8.7
            )
        )

        return movie
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                63174,
                "Lucifer",
                "2016-01-25",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "en",
                "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                8.5
            )
        )

        tvShow.add(
            TvShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "en",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                7.9
            )
        )

        tvShow.add(
            TvShowEntity(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "en",
                "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                8.6
            )
        )

        tvShow.add(
            TvShowEntity(
                1399,
                "Game of Thrones",
                "2018-04-22",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "en",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8.4
            )
        )

        tvShow.add(
            TvShowEntity(
                60735,
                "The Flash",
                "2016-09-23",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                7.7
            )
        )
        return tvShow
    }

    fun getRemoteMovies(): ArrayList<MovieRemote> {

        val remoteMovie = ArrayList<MovieRemote>()

        remoteMovie.add(
            MovieRemote(
                632357,
                "The Unholy",
                "2021-03-31",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "en",
                "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
                7.1
            )
        )

        remoteMovie.add(
            MovieRemote(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "en",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                7.5
            )
        )

        remoteMovie.add(
            MovieRemote(
                615457,
                "Nobody",
                "2021-03-24",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "en",
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                8.4
            )
        )

        remoteMovie.add(
            MovieRemote(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "en",
                "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                8.5
            )
        )

        remoteMovie.add(
            MovieRemote(
                337404,
                "Cruella",
                "2021-05-26",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "en",
                "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                8.7
            )
        )

        return remoteMovie
    }


    fun getRemoteTVShows(): ArrayList<TvShowRemote> {

        val tvShowRemote = ArrayList<TvShowRemote>()

        tvShowRemote.add(
            TvShowRemote(
                63174,
                "Lucifer",
                "2016-01-25",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "en",
                "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                8.5
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                88396,
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "en",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                7.9
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "en",
                "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                8.6
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                1399,
                "Game of Thrones",
                "2018-04-22",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "en",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8.4
            )
        )

        tvShowRemote.add(
            TvShowRemote(
                60735,
                "The Flash",
                "2016-09-23",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                7.7
            )
        )
        return tvShowRemote
    }
}
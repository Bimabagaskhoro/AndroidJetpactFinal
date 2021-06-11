package com.bimabagaskhoro.submissionjetpactpro3.utils

import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowDetailResponse

object DataDetailDummy {
    fun getDetailMovie(): MovieEntity {
        return MovieEntity(
            632357,
            "The Unholy",
            "2021-03-31",
            "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "en",
            "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
            7.1
        )
    }

    fun getDetailTVShow(): TvShowEntity {
        return TvShowEntity(
            63174,
            "Lucifer",
            "2016-01-25",
            "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "en",
            "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            8.5
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            632357,
            "The Unholy",
            "2021-03-31",
            "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "en",
            "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
            7.1
            )
    }

    fun getRemoteDetailTVShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            63174,
            "Lucifer",
            "2016-01-25",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            "en",
            "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            8.5
        )
    }
}
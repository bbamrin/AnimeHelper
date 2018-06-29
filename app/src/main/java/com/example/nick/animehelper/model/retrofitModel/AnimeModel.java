
package com.example.nick.animehelper.model.retrofitModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AnimeModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("russian")
    @Expose
    private String russian;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("episodes")
    @Expose
    private Integer episodes;
    @SerializedName("episodes_aired")
    @Expose
    private Integer episodesAired;
    @SerializedName("aired_on")
    @Expose
    private String airedOn;
    @SerializedName("released_on")
    @Expose
    private String releasedOn;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("english")
    @Expose
    private List<String> english = null;
    @SerializedName("japanese")
    @Expose
    private List<String> japanese = null;
    @SerializedName("synonyms")
    @Expose
    private List<String> synonyms = null;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_source")
    @Expose
    private String descriptionSource;
    @SerializedName("franchise")
    @Expose
    private String franchise;
    @SerializedName("favoured")
    @Expose
    private String favoured;
    @SerializedName("anons")
    @Expose
    private String anons;
    @SerializedName("ongoing")
    @Expose
    private String ongoing;
    @SerializedName("thread_id")
    @Expose
    private Integer threadId;
    @SerializedName("topic_id")
    @Expose
    private Integer topicId;
    @SerializedName("myanimelist_id")
    @Expose
    private Integer myanimelistId;
    @SerializedName("rates_scores_stats")
    @Expose
    private List<RatesScoresStat> ratesScoresStats = null;
    @SerializedName("rates_statuses_stats")
    @Expose
    private List<RatesStatusesStat> ratesStatusesStats = null;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("next_episode_at")
    @Expose
    private String nextEpisodeAt;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("studios")
    @Expose
    private List<Studio> studios = null;
    @SerializedName("videos")
    @Expose
    private List<Object> videos = null;
    @SerializedName("screenshots")
    @Expose
    private List<Object> screenshots = null;
    @SerializedName("user_rate")
    @Expose
    private String userRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Integer getEpisodesAired() {
        return episodesAired;
    }

    public void setEpisodesAired(Integer episodesAired) {
        this.episodesAired = episodesAired;
    }

    public String getAiredOn() {
        return airedOn;
    }

    public void setAiredOn(String airedOn) {
        this.airedOn = airedOn;
    }

    public String getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(String releasedOn) {
        this.releasedOn = releasedOn;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getEnglish() {
        return english;
    }

    public void setEnglish(List<String> english) {
        this.english = english;
    }

    public List<String> getJapanese() {
        return japanese;
    }

    public void setJapanese(List<String> japanese) {
        this.japanese = japanese;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionSource() {
        return descriptionSource;
    }

    public void setDescriptionSource(String descriptionSource) {
        this.descriptionSource = descriptionSource;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getFavoured() {
        return favoured;
    }

    public void setFavoured(String favoured) {
        this.favoured = favoured;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getMyanimelistId() {
        return myanimelistId;
    }

    public void setMyanimelistId(Integer myanimelistId) {
        this.myanimelistId = myanimelistId;
    }

    public List<RatesScoresStat> getRatesScoresStats() {
        return ratesScoresStats;
    }

    public void setRatesScoresStats(List<RatesScoresStat> ratesScoresStats) {
        this.ratesScoresStats = ratesScoresStats;
    }

    public List<RatesStatusesStat> getRatesStatusesStats() {
        return ratesStatusesStats;
    }

    public void setRatesStatusesStats(List<RatesStatusesStat> ratesStatusesStats) {
        this.ratesStatusesStats = ratesStatusesStats;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNextEpisodeAt() {
        return nextEpisodeAt;
    }

    public void setNextEpisodeAt(String nextEpisodeAt) {
        this.nextEpisodeAt = nextEpisodeAt;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public List<Object> getVideos() {
        return videos;
    }

    public void setVideos(List<Object> videos) {
        this.videos = videos;
    }

    public List<Object> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Object> screenshots) {
        this.screenshots = screenshots;
    }

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }



}

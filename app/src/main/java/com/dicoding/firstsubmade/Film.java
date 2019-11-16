package com.dicoding.firstsubmade;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
    private String judul;
    private String tglRilis;
    private String durasi;
    private String genre;
    private String sutradaraFilm;
    private String sinopsis;
    private String rate;
    private int mainPicture, bgPicture;

    public Film() {
    }

    protected Film(Parcel in) {
        this.judul = in.readString();
        this.tglRilis = in.readString();
        this.durasi = in.readString();
        this.genre = in.readString();
        this.sutradaraFilm = in.readString();
        this.sinopsis = in.readString();
        this.rate = in.readString();
        this.mainPicture = in.readInt();
        this.bgPicture = in.readInt();
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTglRilis() {
        return tglRilis;
    }

    public void setTglRilis(String tglRilis) {
        this.tglRilis = tglRilis;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSutradaraFilm() {
        return sutradaraFilm;
    }

    public void setSutradaraFilm(String sutradaraFilm) {
        this.sutradaraFilm = sutradaraFilm;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(int mainPicture) {
        this.mainPicture = mainPicture;
    }

    public int getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(int bgPicture) {
        this.bgPicture = bgPicture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.tglRilis);
        dest.writeString(this.durasi);
        dest.writeString(this.genre);
        dest.writeString(this.sutradaraFilm);
        dest.writeString(this.sinopsis);
        dest.writeString(this.rate);
        dest.writeInt(this.mainPicture);
        dest.writeInt(this.bgPicture);
    }
}

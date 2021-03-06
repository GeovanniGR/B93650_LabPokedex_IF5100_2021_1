
package com.example.b93650_labpokedex_if5100.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ability implements Serializable, Parcelable
{

    @SerializedName("ability")
    @Expose
    private Ability_ ability;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("slot")
    @Expose
    private Integer slot;
    public final static Creator<Ability> CREATOR = new Creator<Ability>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        public Ability[] newArray(int size) {
            return (new Ability[size]);
        }

    }
    ;
    private final static long serialVersionUID = 901105255353843808L;

    protected Ability(Parcel in) {
        this.ability = ((Ability_) in.readValue((Ability_.class.getClassLoader())));
        this.isHidden = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.slot = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Ability() {
    }

    public Ability_ getAbility() {
        return ability;
    }

    public void setAbility(Ability_ ability) {
        this.ability = ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ability);
        dest.writeValue(isHidden);
        dest.writeValue(slot);
    }

    public int describeContents() {
        return  0;
    }

}

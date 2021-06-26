
package com.example.b93650_labpokedex_if5100.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable, Parcelable
{

    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    public final static Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5747108332926241848L;

    protected Pokemon(Parcel in) {
        in.readList(this.abilities, (Ability.class.getClassLoader()));
        this.baseExperience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isDefault = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationAreaEncounters = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sprites = ((Sprites) in.readValue((Sprites.class.getClassLoader())));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Pokemon() {
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(abilities);
        dest.writeValue(baseExperience);
        dest.writeValue(height);
        dest.writeValue(id);
        dest.writeValue(isDefault);
        dest.writeValue(locationAreaEncounters);
        dest.writeValue(name);
        dest.writeValue(order);
        dest.writeValue(sprites);
        dest.writeValue(weight);
    }

    public int describeContents() {
        return  0;
    }

}

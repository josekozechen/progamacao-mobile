package com.example.disney;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CharacterResponse {

    @SerializedName("info")
    private Info info;

    @SerializedName("data")
    private List<Character> data;

    public Info getInfo() {
        return info;
    }

    public List<Character> getData() {
        return data;
    }

    public class Info {
        @SerializedName("count")
        private int count;

        @SerializedName("totalPages")
        private int totalPages;

        @SerializedName("previousPage")
        private String previousPage;

        @SerializedName("nextPage")
        private String nextPage;

        public int getCount() {
            return count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public String getPreviousPage() {
            return previousPage;
        }

        public String getNextPage() {
            return nextPage;
        }
    }

    public class Character {
        @SerializedName("_id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("imageUrl")
        private String imageUrl;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}

package net.BabaJI.journalApp.ResponseAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class WeatherResponse {

    private Location location;
    private Current current;
    @Data
    public static class Location {
        private String name;
        private String region;
        private String country;
        private Double lat;
        private Double lon;
        private String tz_id;
        private Integer localtime_epoch;
        private String localtime;
    }

    @Getter
    @Setter
    @Data
    public static class Current {
        @JsonProperty("last_updated_epoch")
        private Integer lastUpdatedEpoch;
        private String last_updated;
        private Double temp_c;
        private Double temp_f;
        private Integer is_day;
        private Condition condition;
        private Integer wind_mph;
        private Double wind_kph;
        private Integer wind_degree;
        private String wind_dir;
        private Integer pressure_mb;
        private Double pressure_in;
        private Integer precip_mm;
        private Integer precip_in;
        private Integer humidity;
        private Integer cloud;
        private Double feelslike_c;
        private Double feelslike_f;
        private Double windchill_c;
        private Double windchill_f;
        private Double heatindex_c;
        private Double heatindex_f;
        private Double dewpoint_c;
        private Double dewpoint_f;
        private Double vis_km;
        private Integer vis_miles;
        private Double uv;
        private Integer gust_mph;
        private Double gust_kph;
        private Integer short_rad;
        private Integer diff_rad;
        private Integer dni;
        private Integer gti;
        @Data
        public static class Condition {
            private String text;
            private String icon;
            private Integer code;
        }
    }
}

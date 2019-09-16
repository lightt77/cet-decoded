export class Constants {
    // public static HOST_NAME: string = "http://localhost:8080";
    // public static HOST_NAME: string = "";
    public static HOST_NAME: string = "http://contentcrack.in:8080";
    public static GET_SECTIONS: string = "/sections";
    public static GET_SUBSECTIONS_LIST: string = "/sections/{sectionName}/subsections";
    public static GET_EXERCISES_LIST: string = "/subsections/{subsectionName}/exercises";
    public static GET_EXERCISE_INFO: string = "/subsections/{subsectionName}/exercises/{exerciseNumber}";
}
package info.gomeow.seminars;

@Deprecated
public enum Speaker {
    STEVE_MILLER("Steve Miller", 55),
    PHIL_WARD("Phil Ward", 60),
    SEAN_FITZHUGH("Sean Fitzhugh", 60),
    TERRANCE_GREEN("Terrance Green", 60),
    RUSS_BELMONT("Russ Belmont", 45),
    TONY_ARIA("Tony Aria", 45),
    TRAVIS_CLARK("Travis Clark", 60),
    RYAN_ALLEN("Ryan Allen", 60),
    ANDREW_SANDERS("Andrew Sanders", 55),
    CHRIS_KIISKINEN("Chris Kiiskinen", 45),
    DOUG_FRANKLIN("Doug Frankin", 45),
    MR_ADAMS("Mr. Adams", 45),
    MR_SOLIVA("Mr. Soliva", 45),
    MR_IMBRIALE("Mr. Imbriale", 45),
    DR_JUNG("Dr. Jung", 45);


    Speaker(String s, int si) {
        name = s;
        cap = si;
    }

    String name;
    int cap;

    public String getName() {
        return name;
    }

    public int getCap() {
        return cap;
    }
}

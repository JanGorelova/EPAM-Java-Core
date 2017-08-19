package threadsreader.model;

import java.util.Arrays;
import java.util.Objects;

public final class UserVisit {
    public final int id;
    public final String url;
    public final Integer time;

    public UserVisit(final int id, final String url, final Integer time) {
        this.id = id;
        this.url = url;
        this.time = time;
    }

    @Override
    public final boolean equals(final Object obj) {
        return obj != null && obj instanceof UserVisit && this.id == ((UserVisit) obj).id && Objects.equals(this.url, ((UserVisit) obj).url);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] {id, url});
    }

    @Override
    public String toString() {
        return id + ";" + url + ";" + time;
    }
}
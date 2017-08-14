package threadsreader;

import java.util.Arrays;
import java.util.Objects;

public final class UserInformation {
    final int id;
    final String url;

    public UserInformation(final int id,final String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public final boolean equals(final Object obj) {
        return obj != null && obj instanceof UserInformation && this.id == ((UserInformation) obj).id && Objects.equals(this.url, ((UserInformation) obj).url);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] {id, url});
    }

    @Override
    public String toString() {
        return "User " + id + " have visited site " + url;
    }
}

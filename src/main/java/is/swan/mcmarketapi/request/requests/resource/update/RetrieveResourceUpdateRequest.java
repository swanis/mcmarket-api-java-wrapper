package is.swan.mcmarketapi.request.requests.resource.update;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Update;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceUpdateRequest implements Request<Update> {

    private final int resourceId, updateId;

    public RetrieveResourceUpdateRequest(int resourceId, int updateId) {
        this.resourceId = resourceId;
        this.updateId = updateId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/updates/" + updateId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Update handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceUpdateJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Update resourceUpdate = gson.fromJson(resourceUpdateJson, Update.class);

        return resourceUpdate;
    }
}

class Twofer {
    String twofer(String name) {
        String result = "";
        if (name == null) {
            result = "One for you, one for me.";
        }
        else {
            result = String.format("One for %s, one for me.", name);
        }
        return result;
    }
}

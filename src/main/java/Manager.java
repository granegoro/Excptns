public class Manager {
    protected Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] getAll() {
        return repository.products;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}


    //EntityManager use EntityManagerFactory interface and it's provide connection between Persistence-Unit
    //EntityManager provide CRUD process on persistence.
    EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public Movie create(Movie movie) {
        entityManager.getTransaction().begin();


        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Movie find(int id) {
        return null;
    }

    @Override
    public Movie update(int id) {
        return null;
    }

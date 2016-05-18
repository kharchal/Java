package main.hav.entity;


public class Expression {
    private int id;
    private String expression;
    private double result;
    private User user;
    private String timestamp;

    public Expression() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expression that = (Expression) o;

        if (id != that.id) return false;
        if (Double.compare(that.result, result) != 0) return false;
        if (expression != null ? !expression.equals(that.expression) : that.expression != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        result1 = id;
        result1 = 31 * result1 + (expression != null ? expression.hashCode() : 0);
        temp = Double.doubleToLongBits(result);
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        result1 = 31 * result1 + (user != null ? user.hashCode() : 0);
        result1 = 31 * result1 + (timestamp != null ? timestamp.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "id=" + id +
                ", expression='" + expression + '\'' +
                ", result=" + result +
                ", user=" + user +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

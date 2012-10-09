// Autogenerated AST node
package org.python.pydev.parser.jython.ast;

import org.python.pydev.parser.jython.SimpleNode;
import java.util.Arrays;

public final class Exec extends stmtType {
    public exprType body;
    public exprType globals;
    public exprType locals;

    public Exec(exprType body, exprType globals, exprType locals) {
        this.body = body;
        this.globals = globals;
        this.locals = locals;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((globals == null) ? 0 : globals.hashCode());
        result = prime * result + ((locals == null) ? 0 : locals.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Exec other = (Exec) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (globals == null) {
            if (other.globals != null)
                return false;
        } else if (!globals.equals(other.globals))
            return false;
        if (locals == null) {
            if (other.locals != null)
                return false;
        } else if (!locals.equals(other.locals))
            return false;
        return true;
    }

    public Exec createCopy() {
        return createCopy(true);
    }

    public Exec createCopy(boolean copyComments) {
        Exec temp = new Exec(body != null ? (exprType) body.createCopy(copyComments) : null,
                globals != null ? (exprType) globals.createCopy(copyComments) : null,
                locals != null ? (exprType) locals.createCopy(copyComments) : null);
        temp.beginLine = this.beginLine;
        temp.beginColumn = this.beginColumn;
        if (this.specialsBefore != null && copyComments) {
            for (Object o : this.specialsBefore) {
                if (o instanceof commentType) {
                    commentType commentType = (commentType) o;
                    temp.getSpecialsBefore().add(commentType.createCopy(copyComments));
                }
            }
        }
        if (this.specialsAfter != null && copyComments) {
            for (Object o : this.specialsAfter) {
                if (o instanceof commentType) {
                    commentType commentType = (commentType) o;
                    temp.getSpecialsAfter().add(commentType.createCopy(copyComments));
                }
            }
        }
        return temp;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Exec[");
        sb.append("body=");
        sb.append(dumpThis(this.body));
        sb.append(", ");
        sb.append("globals=");
        sb.append(dumpThis(this.globals));
        sb.append(", ");
        sb.append("locals=");
        sb.append(dumpThis(this.locals));
        sb.append("]");
        return sb.toString();
    }

    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitExec(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (body != null) {
            body.accept(visitor);
        }
        if (globals != null) {
            globals.accept(visitor);
        }
        if (locals != null) {
            locals.accept(visitor);
        }
    }

}

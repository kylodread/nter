/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.model.api.v1.admin.subscription;

import alfio.model.subscription.SubscriptionDescriptor.SubscriptionTimeUnit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StandardPeriodTerm implements SubscriptionTerm {

    private final SubscriptionTimeUnit timeUnit;
    private final Integer units;

    @JsonCreator
    public StandardPeriodTerm(@JsonProperty("timeUnit") SubscriptionTimeUnit timeUnit,
                              @JsonProperty("units") Integer units) {
        this.timeUnit = timeUnit;
        this.units = units;
    }

    @Override
    public boolean validate() {
        return timeUnit != null && units != null && units > 0;
    }

    @Override
    public SubscriptionTimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public Integer getUnits() {
        return units;
    }
}

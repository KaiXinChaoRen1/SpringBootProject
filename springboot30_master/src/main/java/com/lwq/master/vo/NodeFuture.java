package com.lwq.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.concurrent.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeFuture {

    NodeVo nodeVo;
    Future<Object> future;

}
